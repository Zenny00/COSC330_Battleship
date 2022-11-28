//Name(s): Joshua Comfort & Justin Conklin
//Date: 10/5/2022
//Description: Implementation of the controller which will allow for interation between the model and view
//Water sprite based on: https://www.deviantart.com/oni1ink/art/Tutorial-How-to-draw-Water-645199166

//Import required libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Point;

import java.awt.image.*;
import java.io.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.concurrent.ThreadLocalRandom;

public class Player
{
	// May want to use multithreading for the view and server
	//Player has three members Model, View, and role (either client or server)
	private View view; //View (displays the game)
	private Role role; //Role (determiens network actions, server or client)
	private Model model; //Model (game state)
	private State state; //State (current action being taken by the player, setup, attacking, etc)
	private boolean gameStart = false; //Set to true when the setup phase is complete

	private StatusPanel status_board;

	//Player constructor
	public Player(Role role)
	{
		this.role = role; //assign role
		this.model = new Model(); //Setup new model
		this.status_board = new StatusPanel(role); //Create new status board to display the current state of the game
		this.view = new View(model, status_board); //Create a new view
		
		//Add action listeners to the view
		view.addTileListener(new TileListener());
		view.addDoneListener(new DoneListener());	
		view.addResetListener(new ResetListener());
		view.addRestartListener(new RestartListener());	
		view.addExitListener(new ExitListener());

		//Setup state and run the socket
		state = new Initial(this);
		role.run();
	}

	//Reset the game by calling start game and reseting components
	public void resetGame()
	{
		//Set the state back to the initial state
		state = new Initial(this);
		
		//Call the reset view function
		view.resetView();

		//Reset each of the game compoents to their initial state
		model.getTargetBoard().resetBoard();
		view.resetTargetBoard();
		view.resetShips();
		view.resetButtons();
		view.resetOceanBoard();
		model.resetShips();
		model.resetOcean();
		role.resetField();
		status_board.resetPanel();
	}

	//Get the points from the from the other player
	public Point getPoints()
	{
		//Hold the shot read from the client
		String shot = role.readMessage();
			
		//Convert to point
		String coords[] = shot.split(" ");
		return new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
	}

	//Function called when a player is defending
	public void defendAction()
	{
		//Two miss icons are used to reduce redundancy in the view
		Icon player_miss[] = new Icon[2];
		player_miss[0] = sourceIcon("Graphics/Water/WaterStruck.png");
		player_miss[1] = sourceIcon("Graphics/Water/WaterStruck2.png");

		//Get the points from the other player
		Point point = getPoints();
				
		//Get row and column for the shot
		int row = (int)point.getX();
		int column = (int)point.getY();

		//Check all the ships for a hit
		ShipType hit_ship = model.checkShips(row, column); 

		//Check if the current player has lost, if so send info the other player and exit
		if (model.hasLost())
		{
			//Send message to other player
			role.sendMessage("GAMEOVER");
	
			//Dispaly losing screen	
			view.displayLoss();
		}
		else
		{	
			//Write the result of the shot to the buffer
			if (hit_ship != null)
			{
				//Get the ship icon and place an explosion over top of it
				Icon explosion = sourceIcon("Graphics/Ships/Explosion.png");	
				Icon ship_icon = view.getShipButton(row, column).getIcon();
				CompoundIcon new_icon = new CompoundIcon(ship_icon, explosion);
				view.updateShipButton(row, column, new_icon);

				//Check if ship was sunk, if so update local icon and send message 
				if (model.getShip(hit_ship.getIndex()).isSunk())
				{
					//Play sinking sound
					view.playShipSunk();
					//Update the status
					status_board.friendlyShipDestroyed(hit_ship);

					//Update message board and send message to other player
					role.writeStatus("The enemy SUNK your " + hit_ship);
					role.sendMessage("11" + " " + hit_ship.getIndex());
				}
				else
				{
					//Play hit sound
					view.playEnemyHit();

					//Update message board and send message to the other player
					role.writeStatus("The enemy HIT your " + hit_ship);
					role.sendMessage("10" + " " + hit_ship.getIndex());
				}
			}	
			else
			{
				//Update ocean board to splash icon
				view.updateShipButton(row, column, player_miss[ThreadLocalRandom.current().nextInt(0, 1 + 1)]);
				//Play missing sound effect
				view.playEnemyMiss();

				//Update message board and send message to the other player
				role.writeStatus("The enemy MISSED your ship!");
				role.sendMessage("00" + " 0");
			}

			//Enable the target board
			state = new Attack(this);
		}
	}

	//Method to setup the initial game state and let the server play first
	public void startGame()
	{
		//Get message from client and server accordingly	
		String message = role.readMessage();
			
		if (!message.equals("ready"))
		{
			System.out.println("Error starting game");
			System.exit(0);
		}
		
		//Start the game for the client and server
		if (role instanceof Client)
		{
			//Client starts by defending
			state = new Defend(this);
			defendAction();
		}
		else
			//Set the server state to attack
			state = new Attack(this);
	}

	//Get icon from url
	public Icon sourceIcon(String str)
	{
		//Get url
		URL img_url = getClass().getResource(str);

		//Create new buffered image
		BufferedImage buf_img = null;

		//Attempt to read the image
		try
		{
			buf_img = ImageIO.read(img_url);
		}
		catch (IOException ex)
		{
			System.out.println(ex.toString());	
		}

		//Return an image icon
		return new ImageIcon(buf_img);
	}

	// Enable/Disable for Target Button Panel
	// True enables the board
	// False disables all tiles in the panel
	public void setTargetBoardEnabled(boolean isEnabled) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() 
			{   	
				//Get JPanel from the view
				JPanel panel = view.getTargetPanel();
				Component[] tiles = panel.getComponents();
				
				//Set each icon to enabled or disabled
				for (Component tile : tiles)
					tile.setEnabled(isEnabled);

				panel.revalidate();
				panel.repaint();
			}
		});
	}

	//Set the target icon to a hit or miss
	public void setTargetIcon(int row, int column, String source)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() 
			{   	
				//Set the icon and redraw
				view.getTargetButton(row, column).setIcon(sourceIcon(source));
				view.getTargetButton(row, column).repaint();
			}
		});
	}

	//Inner class to listen for player clicks on the target board
	class TileListener implements ActionListener
	{
		//When a tile is pressed grab the coordinates
		public void actionPerformed(ActionEvent e)
		{
			//Run in a separate thread
			Thread actionThread = new Thread()
			{
				public void run()
				{
					//Check that source is a JButton
					Object obj = e.getSource();
					if (!(obj instanceof JButton))
						return;

					JButton button = (JButton)obj;

					//Get coordinates from the button
					String coords[] = button.getActionCommand().split(" ");
					Point point = new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
				
					//If the button can be clicked process the information	
					if (model.validTarget((int)point.getY(), (int)point.getX()))
					{		
						//Update the model
						model.fireShot((int)point.getY(), (int)point.getX()); 
						
						//Send shot coordinates to the other player
						role.sendMessage((int)point.getY() + " " + (int)point.getX());

						state = new Defend(Player.this);
						String shot_status = role.readMessage();		

						//Check if game has been won
						if (shot_status.equals("GAMEOVER"))
							//Display win	
							view.displayWin();
						else
						{
							//Get result of shot and ship hit
							String values[] = shot_status.split(" ");
							int ship_index = Integer.parseInt(values[1]);

							String shot_value = values[0];
							ShipType ship_type = ShipType.values()[ship_index];

							//Check if shot was a hit or a miss
							if (shot_value.equals("10"))
							{
								//Shot was a hit but ship was not sunk
								setTargetIcon((int)point.getY(), (int)point.getX(), "./Graphics/Water/WaterHit.png");	
								view.playHit();

								//Write to the game console
								role.writeStatus("You HIT an enemy ship!");
							}
							else if (shot_value.equals("11"))
							{
								//Update game status
								status_board.enemyShipDestroyed(ship_type);	

								//Shot was a hit and ship was sunk
								setTargetIcon((int)point.getY(), (int)point.getX(), "./Graphics/Water/WaterHit.png");
								view.playShipSunk();

								//Write to the game console
								role.writeStatus("You SUNK the enemy " + ship_type + "!");
							}
							else
							{
								//Shot was a miss
								setTargetIcon((int)point.getY(), (int)point.getX(), "./Graphics/Water/WaterMiss.png");
								view.playMiss();
								
								//Write to the game console
								role.writeStatus("You MISSED the enemy!");
							}

							//Move to defending state
							defendAction();
						}
					}
					else
						//If shot was invalid, play sound and flash board color
						view.targetBoardError();
				}
			};

			//Run in thread
			actionThread.start();
		}
	} //Inner actionListener class

	//Listen for the player to be done with their ship setup
	class DoneListener implements ActionListener
	{
		//When a tile is pressed grab the coordinates
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if (obj instanceof JButton)
			{
				//Hide buttons and play background music
				view.startBackgroundMusic();
				view.hideReset();

				JButton button = (JButton)obj;

				//Set self to invisible
				button.setVisible(false);
				button.setEnabled(false);

				//Set game started to true
				gameStart = true;

				//Send message to other player
				role.sendMessage("ready");

				//Call start game function
				startGame();
			}
		}
	}

	//Listener for the reset button
	class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if (obj instanceof JButton)
			{
				//If reset button is pressed reset ships in the view and model
				view.resetShips();
				view.resetButtons();
				view.resetOceanBoard();
				model.resetShips();
				model.resetOcean();
			}
		}
	}

	//Listener for the exit button
	class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if (obj instanceof JButton)
			{
				//Exit the game
				role.closeConnection();
				System.exit(0);
			}
		}
	}

	//Listener for the restart button
	class RestartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if (obj instanceof JButton)
				//Restart the game
				resetGame();
		}
	}
}	
