//Super class for ship view class
//Name(s): Joshua Comfort & Justin Conklin
//Description: Ship JLabel that holds ship information for the view

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
	//Direction, length, and type	
	protected int direction;
        protected int length;
	protected ShipType type;

	//Icon resources
	protected String up_resource;
        protected String left_resource;
        protected Icon up_icon = null;
        protected Icon left_icon = null;
        protected Icon up_sprites[] = null;
        protected Icon up_error = null;
        protected Icon left_error = null;
        protected Icon left_sprites[] = null;	
	
	//Constructor	
	public ShipLabel(String up_resource, String left_resource, String up_error_resource, String left_error_resource)
	{
		//Up and left icons
                up_icon = sourceIcon(up_resource);
		left_icon = sourceIcon(left_resource);
		
		//Error icons
		up_error = sourceIcon(up_error_resource);
		left_error = sourceIcon(left_error_resource);
		
		//Set rotation handler and default icon
		addMouseListener(new RotationHandler());
		setIcon(up_icon);
	}

	//Getters for each icon
	public Icon getUpIcon()
	{
		return up_icon;
	}

	public Icon getLeftIcon()
	{
		return left_icon;
	}

	public Icon getUpErrorIcon()
	{
		return up_error;
	}

	public Icon getLeftErrorIcon()
	{
		return left_error;
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

	//Get sprites
	public Icon[] getUpSprites()
	{
		return up_sprites;
	}

	public Icon[] getLeftSprites()
	{
		return left_sprites;
	}

	//Get the ship type
	public ShipType getType()
	{
		return type;
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

	//Allows the user to rotate the ship
	class RotationHandler extends MouseAdapter
        {
                @Override
                public void mouseClicked(MouseEvent e)
                {
			//If the user right clicks rotate the icon
                        if (e.getModifiers() == MouseEvent.BUTTON3_MASK)
                        {
                                Object obj = e.getSource();
                                if (obj instanceof JLabel)
                                {
					//Change the direction
                                        direction++;
                                        if (direction > 1)
                                                direction = 0;

                                        JLabel ship = (JLabel)obj;

					//Update the icon
                                        if (direction == 0)
                                                ship.setIcon(up_icon);
                                        else
                                                ship.setIcon(left_icon);

					//Repaint
                                        ship.revalidate();
                                        ship.repaint();
                                }
                        }
                }
        }		
}	
