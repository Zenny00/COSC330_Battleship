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
	private View view;
	//private	Server application = new Server(); // create server
	private Role role;
	private Model model;
	private State state;

	public Player(View view, Role role)
	{
		this.view = view;
		this.role = role;
		this.state = new Initial(this);
		view.addTileListener(new TileListener());
      		//role.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      		role.runServer(); // run server application
	}

	// Enable/Disable for Target Button Panel
	// True enables board and checks if each button is clickable
	// False disables all tiles in the panel
	public void setTaretBoardEnabled(boolean isEnabled) {
		int x, y;
		view.getTargetPanel().setEnabled(isEnabled);

		Component[] tiles = panel.getComponenets();
		for (Component tile : tiles) {
			String coords[] = tile.getActionCommand().split(" ");
			x = Integer.parseInt(coords[0]);
			y = Integer.parseInt(coords[1]);
			if (Model.getTargetBoard().getClickable(x, y) && isEnabled)
				tile.setEnabled(isEnabled);
			else
				tile.setEnabled(false);
		}
	}

	public void setOceanBoardEnabled(boolean isEnabled) {
		int x, y;
		view.getShipPanel().setEnabled(isEnabled);

		Component[] tiles = panel.getComponents();
		for (Component tile : tiles)
			tile.setEnabled(isEnabled);
	}

	class TileListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if (!(obj instanceof JButton))
				return;

			JButton button = (JButton)obj;
			String coords[] = button.getText().split(" ");
			Point point = new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
                	//System.out.println(point.getX() + " " + point.getY());
			role.sendData(point.getX() + " " + point.getY());
		}
	} //Inner actionListener class

}
