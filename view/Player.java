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

public class Player
{
	// May want to use multithreading for the view and server
	//Player has three members Model, View, and role (either client or server)
	private View view;
	private Role role;
	private Model model;
	private State state;
	private boolean gameStart = false;

	private final String SERVER = "SERVER";
	private final String CLIENT = "CLIENT";

	//Player constructor
	public Player(Role role)
	{
		this.role = role; //assign role
		this.model = new Model(); //Setup new model
		this.view = new View(model, role); //Create a new view

		//Add action listeners to the view
		view.addTileListener(new TileListener());
		view.addDoneListener(new DoneListener());	

		state = new Initial(this);
		role.run();
	}

	public void startGame()
	{
		System.out.println("Start game called");
		// run client or server
		
		String message = "";
		
		message = role.readMessage();
		System.out.println(message);
		
		if (message.equals("ready"))
			System.out.println("Game has begun");
		else
			System.out.println("Game has not begun");
		
		//state = new Attack(model, view);

		// NOTE: Bad way to do this but it'll work for now
		if (role.getRole() == CLIENT)
			System.out.println("CODE FOR CLIENT");
			//RUN CLIENT CODE
		else
			System.out.println("CODE FOR SERVER");
			//RUN SERVER CODE
		
		role.closeConnection();
	}

	// Enable/Disable for Target Button Panel
	// True enables board and checks if each button is clickable
	// False disables all tiles in the panel
	public void setTargetBoardEnabled(boolean isEnabled) {
		int row, column;	
		System.out.println("Set board called");
		JPanel panel = null;

		view.getTargetPanel().setEnabled(isEnabled);
		
		//Get JPanel from the view
		Component[] tiles = view.getTargetPanel().getComponents();
		for (Component tile : tiles) {
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
		}
	}

	public void setOceanBoardEnabled(boolean isEnabled) {
		int row, column;
		view.getShipPanel().setEnabled(isEnabled);

		Component[] tiles = view.getShipPanel().getComponents();
		for (Component tile : tiles)
			tile.setEnabled(isEnabled);
	}

	class TileListener implements ActionListener
	{
		//When a tile is pressed grab the coordinates
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if (!(obj instanceof JButton))
				return;

			JButton button = (JButton)obj;
			button.setIcon(new ImageIcon("./Graphics/Water/WaterMiss.png"));
			
			String coords[] = button.getActionCommand().split(" ");
			Point point = new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
                	System.out.println(point.getX() + " " + point.getY());
			role.sendMessage(point.getX() + " " + point.getY());
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
}
