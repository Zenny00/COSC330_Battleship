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
	//View
	private View view;
	//private	Server application = new Server(); // create server
	private Role role;
	// private Model model;

	public Player(Role role)
	{
		this.role = role;
		this.view = new View(role);
		view.addTileListener(new TileListener());
		view.addClickListener(new DragListener());
		view.addDragListener(new DragListener());
      		//role.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      		role.run(); // run server application
	}

	class TileListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if (!(obj instanceof JButton))
				return;

			JButton button = (JButton)obj;
			button.setIcon(new ImageIcon("./WaterMiss.png"));
			
			String coords[] = button.getActionCommand().split(" ");
			Point point = new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
                	System.out.println(point.getX() + " " + point.getY());
			role.sendData(point.getX() + " " + point.getY());
		}
	} //Inner actionListener class


	class DragListener implements MouseListener, MouseMotionListener
	{
		private Point start_point;
		
		public void buttonActionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			JPanel panel = null;
			if (obj instanceof JPanel)
				panel = (JPanel)obj;
			
			panel.revalidate();
			panel.repaint();
		}

		public void mousePressed(MouseEvent e)
		{
			Object obj = e.getSource();
			JPanel panel = null;
			if (obj instanceof JPanel)
			{
				System.out.println("HI");
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
