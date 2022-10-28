//Name(s): Joshua Comfort & Justin Conklin
//Date: 10/5/2022
//Description: Implementation of the view class for the Battleship game GUI
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

public class Player
{
	// May want to use multithreading for the view and server
	//Player has three members Model, View, and role (either client or server)
	private View view; //View (displays the game)
	private Role role; //Role (determiens network actions, server or client)
	private Model model; //Model (game state)
	private State state; //State (current action being taken by the player, setup, attacking, etc)
	private ChatRole chat;
	private boolean gameStart = false; //Set to true when the setup phase is complete

	private StatusPanel status_board;

	//Player constructor
	public Player(Role role)
	{
		this.role = role; //assign role
		this.model = new Model(); //Setup new model
		this.status_board = new StatusPanel(); //Create new status board to display the current state of the game
		this.view = new View(model, status_board); //Create a new view
		
		//Add action listeners to the view
		view.addTileListener(new TileListener());
		view.addDoneListener(new DoneListener());	

		state = new Initial(this);
		//setTargetBoardEnabled(false);
		//setTargetBoardEnabled(false);
		//setTargetBoardEnabled(false);
		
		//new Thread(() -> setTargetBoardEnabled(false)).start();

		//Runnable role_runnable = role;
      		//Thread role_thread = new Thread(role_runnable);
      		//role_thread.start();
	   	//System.out.println(role_thread.isAlive());
		role.run();
	}

	public void defendAction()
	{
		//Thread actionThread = new Thread()
		//{
		//	public void run()
		//	{	
		//			
				//Hold the shot read from the client
				String shot = role.readMessage();
					
				//Convert to point
				String coords[] = shot.split(" ");
				Point point = new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
				
				//Get row and column for the shot
				int row = (int)point.getX();
				int column = (int)point.getY();

				//Check all the ships for a hit
				ShipType hit_ship = model.checkShips(row, column); 

				//Check if the current player has lost, if so send info the other player and exit
				if (model.hasLost())
				{
					//Send message to other player
					System.out.println("YOU LOST");	
					role.sendMessage("GAMEOVER");
				
					//Exit the game
					role.closeConnection();
					System.exit(0);
				}	

				//Write the result of the shot to the buffer
				if (hit_ship != null)
				{
						
					//Check if ship was sunk, if so update local icon and send message 
					if (model.getShip(hit_ship.getIndex()).isSunk())
					{
						view.playShipSunk();
						status_board.friendlyShipDestroyed(hit_ship);	
						role.sendMessage("11" + " " + hit_ship.getIndex());
					}
					else
					{
						//Play hit sound
						view.playEnemyHit();
						role.sendMessage("10" + " " + hit_ship.getIndex());
					}
				}	
				else
				{
					view.playEnemyMiss();
					role.sendMessage("00" + " 0");
				}

				//Enable the target board
				//setTargetBoardEnabled(true);	
				state = new Attack(this);
	}

	//Method to setup the initial game state and let the server play first
	public void startGame()
	{
		System.out.println("Start game called");
	
		//Get message from client and server accordingly	
		String message = role.readMessage();
			
		System.out.println(message);
		
		if (message.equals("ready"))
			System.out.println("Game has begun");
		else
			System.out.println("Game has not begun");
		
		if (role instanceof Client)
		{
			state = new Defend(this);
			//setTargetBoardEnabled(false);
			defendAction();
		}
		else
			state = new Attack(this);
			//setTargetBoardEnabled(true);			
	}

	//Get icon
	public Icon sourceIcon(String str)
	{
		URL img_url = getClass().getResource(str);

		BufferedImage buf_img = null;

		try
		{
			buf_img = ImageIO.read(img_url);
		}
		catch (IOException ex)
		{
			System.out.println(ex.toString());	
		}

		return new ImageIcon(buf_img);
	}

	/*	NOTE: NVM IT WONT WORK CAUSE OF THE LOOPS, CAN NEVER PRESS THE BUTTONS
		// NOTE: Bad way to do this but it'll work for now
		if (role.getRole() == CLIENT)
		{
			while (!model.hasLost())
			{
				System.out.println("CODE FOR CLIENT");
				//RUN CLIENT CODE
				
				//Set to defend mode
				//state = new Defend(this);

				}
		}
		else
		{
			//RUN SERVER CODE
			System.out.println("CODE FOR SERVER");
			
			//Set the attack state
			//state = new Attack(this);
			
			while (!model.hasLost())
			{
				//System.out.println("HAS NOT LOST");
			}
		}
	*/

	// Enable/Disable for Target Button Panel
	// True enables board and checks if each button is clickable
	// False disables all tiles in the panel
	public void setTargetBoardEnabled(boolean isEnabled) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() 
			{   	
				int row, column;	
				System.out.println("Set board called");

				//view.getTargetPanel().setEnabled(isEnabled);
				
				//Get JPanel from the view
				JPanel panel = view.getTargetPanel();
				Component[] tiles = panel.getComponents();
				for (Component tile : tiles) {
					tile.setEnabled(isEnabled);
					/*
					if (tile instanceof JButton)
					{
						JButton button = (JButton)tile;	
						String coords[] = button.getActionCommand().split(" ");
						row = Integer.parseInt(coords[0]);
						column = Integer.parseInt(coords[1]);
						if (model.getTargetBoard().getClickable(row, column) && isEnabled)
							tile.setEnabled(isEnabled);
						else
							tile.setEnabled(false);
					}
					*/
				}

				panel.revalidate();
				panel.repaint();
			}
		});
	}

	public void setOceanBoardEnabled(boolean isEnabled) {
		int row, column;
		//view.getShipPanel().setEnabled(isEnabled);
		
		JPanel panel = view.getShipPanel();
		Component[] tiles = panel.getComponents();

		for (Component tile : tiles)
			tile.setEnabled(isEnabled);

		panel.revalidate();
		panel.repaint();
	}

	public void setTargetIcon(int row, int column, String source)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() 
			{   	
				view.getTargetButton(row, column).setIcon(sourceIcon(source));
				view.getTargetButton(row, column).repaint();
			}
		});
	}

	class TileListener implements ActionListener
	{
		//When a tile is pressed grab the coordinates
		public void actionPerformed(ActionEvent e)
		{
			Thread actionThread = new Thread()
			{
				public void run()
				{
					Object obj = e.getSource();
					if (!(obj instanceof JButton))
						return;

					JButton button = (JButton)obj;

					String coords[] = button.getActionCommand().split(" ");
					Point point = new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					System.out.println(point.getY() + " " + point.getX());
					
					if (model.validTarget((int)point.getY(), (int)point.getX()))
					{		
						model.fireShot((int)point.getY(), (int)point.getX()); 
						role.sendMessage((int)point.getY() + " " + (int)point.getX());

						state = new Defend(Player.this);
						//setTargetBoardEnabled(false);		
						String shot_status = role.readMessage();		

						//Check if game has been won
						if (shot_status.equals("GAMEOVER"))
						{
							System.out.println("YOU WON");
							role.closeConnection();
							System.exit(0);
						}

						//Get result of shot and ship hit
						String values[] = shot_status.split(" ");
						int ship_index = Integer.parseInt(values[1]);

						String shot_value = values[0];
						ShipType ship_type = ShipType.values()[ship_index];

						//Check if shot was a hit or a miss
						if (shot_value.equals("10"))
						{
							setTargetIcon((int)point.getY(), (int)point.getX(), "./Graphics/Water/WaterHit.png");	
							view.playHit();
						}
						else if (shot_value.equals("11"))
						{
							status_board.enemyShipDestroyed(ship_type);	
							setTargetIcon((int)point.getY(), (int)point.getX(), "./Graphics/Water/WaterHit.png");
							view.playShipSunk();
						}
						else
						{
							setTargetIcon((int)point.getY(), (int)point.getX(), "./Graphics/Water/WaterMiss.png");
							view.playMiss();
						}

						//setTargetBoardEnabled(false);
						System.out.println("Moving states");
						defendAction();
					}
					else
						view.targetBoardError();
				}
			};
			actionThread.start();
		}
	} //Inner actionListener class

	class DoneListener implements ActionListener
	{
		//When a tile is pressed grab the coordinates
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if (obj instanceof JButton)
			{
				view.startBackgroundMusic();
				JButton button = (JButton)obj;

				button.setVisible(false);
				button.setEnabled(false);

				System.out.println("Player is done the setup phase");
				for (int i = 0; i < 10; i++)
				{
					for (int j = 0; j < 10; j++)
						System.out.printf("%s ", model.getShipBoard().getTile(i, j).getTileType());

					System.out.printf("\n");
				}

				gameStart = true;
				role.sendMessage("ready");
				startGame();
			}
		}
	}

	/*
	//Inner class DragListener allows the player to drag ships to different locations on the ship board
	class DragListener implements MouseListener, MouseMotionListener
	{
		private Point start_point;
		
		public void ActionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			JPanel panel = null;
			if (obj instanceof JPanel)
				panel = (JPanel)obj;
			
			System.out.println("HELLO");
			panel.revalidate();
			panel.repaint();
		}

		public void mousePressed(MouseEvent e)
		{
			Object obj = e.getSource();
			JPanel panel = null;
			if (obj instanceof JPanel)
			{
				System.out.println("HI" + e.getPoint().toString());
				panel = (JPanel)obj;
			}

			start_point = SwingUtilities.convertPoint(panel, e.getPoint(), panel.getParent());
		}

		public void mouseDragged(MouseEvent e)
		{
			Object obj = e.getSource();
			JPanel panel = null;
			if (obj instanceof JPanel)
				panel = (JPanel)obj;

			Point location = SwingUtilities.convertPoint(panel, e.getPoint(), panel.getParent());
			
			if (panel.getParent().getBounds().contains(location))
			{
				Point newLocation = panel.getLocation();
				newLocation.translate(location.x-start_point.x, location.y-start_point.y);
				newLocation.x = Math.max(newLocation.x, 0);
				newLocation.y = Math.max(newLocation.y, 0);
				newLocation.x = Math.min(newLocation.x, panel.getParent().getWidth() - panel.getWidth());
				newLocation.y = Math.min(newLocation.y, panel.getParent().getHeight() - panel.getHeight());
				panel.setLocation(newLocation);
				start_point = location;
			}
		}	

		//Must be defined as we are implementing interfaces
		
		public void mouseReleased(MouseEvent e)
		{
			start_point = null;
		}	

		public void mouseEntered(MouseEvent e)
		{
			//No action
		}

		public void mouseExited(MouseEvent e)
		{
			//No action
		}

		public void mouseClicked(MouseEvent e)
		{
			//No action
		}

		public void mouseMoved(MouseEvent e)
		{
			//No action
		}
	}
	*/
}
