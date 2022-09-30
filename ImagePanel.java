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
	ImageIcon image = new ImageIcon("./View/Graphics/Ships/Submarine.png");

        final int IMG_WIDTH = image.getIconWidth();
        final int IMG_HEIGHT = image.getIconHeight();

        Point image_corner;
        Point previousPoint;

	ImagePanel()
	{
		image_corner = new Point(0, 0);

		ClickListener click_listener = new ClickListener();
		DragListener drag_listener = new DragListener();

		this.addMouseListener(click_listener);
		this.addMouseMotionListener(drag_listener);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		image.paintIcon(this, g, (int)image_corner.getX(), (int)image_corner.getY());
	}

	private class ClickListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			if (((e.getPoint().getX() >= image_corner.getX()) && (e.getPoint().getX() <= image_corner.getX() + IMG_WIDTH)) && ((e.getPoint().getY() >= image_corner.getY()) && (e.getPoint().getY() <= image_corner.getY() + IMG_HEIGHT)))
				previousPoint = e.getPoint();
		}

	}

	public class DragListener extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent e)
		{
			if (((e.getPoint().getX() >= image_corner.getX()) && (e.getPoint().getX() <= image_corner.getX() + IMG_WIDTH)) && ((e.getPoint().getY() >= image_corner.getY()) && (e.getPoint().getY() <= image_corner.getY() + IMG_HEIGHT)))
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
