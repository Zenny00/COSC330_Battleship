//Name: Joshua Comfort
//Date: 10/3/2022
//Description: Image panel definition

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Point;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;

public class ImagePanel extends JPanel
{	
	//Private data members to hold the information assoicated with an icon object
	//private ImageIcon image;
	
   	private ImageIcon image;
	private int img_width;
	private int img_height;

        private Point image_corner;
        private Point previousPoint;

	//Constructor, initalize the panel to a location
	ImagePanel(String source, int x, int y)
	{
		//Setup the icon
		image = new ImageIcon(source);
		img_width = (int)image.getIconWidth();
		img_height = (int)image.getIconHeight();
		image_corner = new Point(x, y);

		//Set the image bounds
		this.setBounds(x, y, x+img_width, y+img_height);

		//Create a drag and click listener and add them to the panel
		ClickListener click_listener = new ClickListener();
		DragListener drag_listener = new DragListener();

		this.addMouseListener(click_listener);
		this.addMouseMotionListener(drag_listener);
		
		//No layout manager and set visible to true
		setLayout(null);
		this.setVisible(true);
	}

	//Paint the panel at the desired location
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		/*this.setBounds(
				((int)image_corner.getX()),
			       	((int)image_corner.getY()),	
				((int)image_corner.getX())+img_width,
			       	((int)image_corner.getY())+img_height);*/
		image.paintIcon(this, g, (int)image_corner.getX(), (int)image_corner.getY());	
	}

	//Check the mouse location and set the previousPoint equal to the mouse event's location
	private class ClickListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			//Check if the mouse is inside the object
			if (((e.getPoint().getX() >= image_corner.getX()) && (e.getPoint().getX() <= image_corner.getX() + img_width)) && ((e.getPoint().getY() >= image_corner.getY()) && (e.getPoint().getY() <= image_corner.getY() + img_height)))
				previousPoint = e.getPoint();
		}

	}

	//Drag event handler
	public class DragListener extends MouseMotionAdapter
	{
		//Check the mouse location and if it is inside the sprite, then allow the user to move the icon
		public void mouseDragged(MouseEvent e)
		{
			//Check the mouse location
			if (((e.getPoint().getX() >= image_corner.getX()) && (e.getPoint().getX() <= image_corner.getX() + img_width)) && ((e.getPoint().getY() >= image_corner.getY()) && (e.getPoint().getY() <= image_corner.getY() + img_height)))
			{
				//Get the point of the event
				Point currentPoint = e.getPoint();
				
				//Transfer the image_corner to the new location
				image_corner.translate(
						(int)(currentPoint.getX() - previousPoint.getX()), 
						(int)(currentPoint.getY() - previousPoint.getY())
						);
			
				//Set the previousPoint to the currentPoint
				previousPoint = currentPoint;
				//Redraw the scene
				repaint();
			}
		}
	}
}
