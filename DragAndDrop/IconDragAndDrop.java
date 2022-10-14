//Name: Joshua Comfort & Justin Conklin
//Date: 10/3/2022
//Description: Allow user to drag from one location to a specified location on the screen

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class IconDragAndDrop
{
	//Main function
	public static void main(String args[])
	{
		//Create a new JFrame
		JFrame frame = new JFrame("Drag and Drop Demo");

		//Create three icons of with the destroyer, sea, and submarine sprites 
		ImageIcon submarine = new ImageIcon("../View/Graphics/Ships/Submarine.png");
		ImageIcon destroyer = new ImageIcon("../View/Graphics/Ships/Destroyer.png");
		ImageIcon water = new ImageIcon("../View/Graphics/Ships/Water.png");

		//Create JLabels for each of the icons
		JLabel water_label = new JLabel(water, JLabel.CENTER);
		JLabel sub_label = new JLabel(submarine, JLabel.CENTER);
		JLabel des_label = new JLabel(destroyer, JLabel.CENTER);

		//Add a mouse listener to the drag and drop adapters
		MouseListener listener = new DragMouseAdapter();
		sub_label.addMouseListener(listener);
		des_label.addMouseListener(listener);

		//Setup TransferHandlers to move icons between the labels
		sub_label.setTransferHandler(new TransferHandler("icon"));
		water_label.setTransferHandler(new TransferHandler("icon"));
		des_label.setTransferHandler(new TransferHandler("icon"));

		//Set the flow layout and add labels to the frame
		frame.setLayout(new FlowLayout());
		frame.add(sub_label);
		frame.add(water_label);
		frame.add(des_label);

		//Pack the frame and configure closing operation
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}
}

//Define the transfer handler
class DragMouseAdapter extends MouseAdapter
{
	//When the mouse is pressed get the source component and transfer the icon to the new location
	public void mousePressed(MouseEvent e)
	{
		JComponent c = (JComponent)e.getSource();
		TransferHandler handler = c.getTransferHandler();
		handler.exportAsDrag(c, e, TransferHandler.COPY);	
	}
}
