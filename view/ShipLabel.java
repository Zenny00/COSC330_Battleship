//Super class for ship view class

//Needed libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.*;
import javax.swing.border.*;
import java.lang.Math;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ShipLabel extends JLabel
{
	private final int BASE_DIMENSION = 30;
	
	protected int direction;
        protected int length;

	private String up_resource;
        private String left_resource;
        protected Icon up_icon = null;
        protected Icon left_icon = null;
        protected Icon up_sprites[] = null;
        protected Icon left_sprites[] = null;	
	
	public ShipLabel(int length, int direction, String up_resource, String left_resource)
	{
                up_icon = sourceIcon(up_resource);
		left_icon = sourceIcon(left_resource);
		
		addMouseListener(new RotationHandler());
		setIcon(up_icon);
	}

	//Getters for length and direction
	int getLength()
	{
		return length;
	}

	int getDirection()
	{
		return direction;
	}

	//Get scaled icon from source
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


	//Rescale icon while keeping aspect ratio (https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon)
	public ImageIcon scaleImage(ImageIcon icon, int w, int h)
        {
                int nw = icon.getIconWidth();
                int nh = icon.getIconHeight();

                if(icon.getIconWidth() > w)
                {
                        nw = w;
                        nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
                }

                if(nh > h)
                {
                        nh = h;
                        nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
                }

                return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
        }


	class RotationHandler extends MouseAdapter
        {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                        if (e.getModifiers() == MouseEvent.BUTTON3_MASK)
                        {
                                Object obj = e.getSource();
                                if (obj instanceof JLabel)
                                {
                                        direction++;
                                        if (direction > 1)
                                                direction = 0;

					System.out.println(direction);
                                        JLabel ship = (JLabel)obj;

                                        if (direction == 0)
                                                ship.setIcon(up_icon);
                                        else
                                                ship.setIcon(left_icon);

                                        ship.revalidate();
                                        ship.repaint();
                                }
                        }
                }
        }		
}	
