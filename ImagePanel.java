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

	ImagePanel(String source, int x, int y)
	{
		image = new ImageIcon(source);
		img_width = (int)image.getIconWidth();
		img_height = (int)image.getIconHeight();
		image_corner = new Point(x, y);

		this.setBounds(x, y, x+img_width, y+img_height);

		ClickListener click_listener = new ClickListener();
		DragListener drag_listener = new DragListener();

		this.addMouseListener(click_listener);
		this.addMouseMotionListener(drag_listener);
		setLayout(null);
		this.setVisible(true);
	}

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

	private class ClickListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			if (((e.getPoint().getX() >= image_corner.getX()) && (e.getPoint().getX() <= image_corner.getX() + img_width)) && ((e.getPoint().getY() >= image_corner.getY()) && (e.getPoint().getY() <= image_corner.getY() + img_height)))
				previousPoint = e.getPoint();
		}

	}

	public class DragListener extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent e)
		{
			if (((e.getPoint().getX() >= image_corner.getX()) && (e.getPoint().getX() <= image_corner.getX() + img_width)) && ((e.getPoint().getY() >= image_corner.getY()) && (e.getPoint().getY() <= image_corner.getY() + img_height)))
			{
				Point currentPoint = e.getPoint();
				
				image_corner.translate(
						(int)(currentPoint.getX() - previousPoint.getX()), 
						(int)(currentPoint.getY() - previousPoint.getY())
						);
			
				previousPoint = currentPoint;
				repaint();
			}
		}
	}
}
