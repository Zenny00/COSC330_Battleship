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
		this.view = new View();
		this.role = role;
		view.addTileListener(new TileListener());
		view.addJPanel(role);
		view.setupView();
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

}
