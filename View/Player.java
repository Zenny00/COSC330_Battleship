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
	private View b_view;

	public Player(View view)
	{
		b_view = view;
		view.addFireListener(new FireListener());
	}

	class FireListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if (!(obj instanceof JButton))
				return;

			JButton source_button = (JButton)obj;
			System.out.println("E");
		}
	} //Inner actionListener class	
}
