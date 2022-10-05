import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class IconDragAndDrop
{
	public static void main(String args[])
	{
		//Create a new JFrame
		JFrame frame = new JFrame("Drag and Drop Demo");

		//Create 
		ImageIcon submarine = new ImageIcon("../View/Graphics/Ships/Submarine.png");
		ImageIcon destroyer = new ImageIcon("../View/Graphics/Ships/Destroyer.png");
		ImageIcon water = new ImageIcon("../View/Graphics/Ships/Water.png");

		JLabel button = new JLabel(water, JLabel.CENTER);

		JLabel sub_label = new JLabel(submarine, JLabel.CENTER);
		JLabel des_label = new JLabel(destroyer, JLabel.CENTER);

		MouseListener listener = new DragMouseAdapter();
		sub_label.addMouseListener(listener);
		des_label.addMouseListener(listener);

		sub_label.setTransferHandler(new TransferHandler("icon"));
		button.setTransferHandler(new TransferHandler("icon"));
		des_label.setTransferHandler(new TransferHandler("icon"));

		frame.setLayout(new FlowLayout());
		frame.add(sub_label);
		frame.add(button);
		frame.add(des_label);

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}
}

class DragMouseAdapter extends MouseAdapter
{
	public void mousePressed(MouseEvent e)
	{
		JComponent c = (JComponent)e.getSource();
		TransferHandler handler = c.getTransferHandler();
		handler.exportAsDrag(c, e, TransferHandler.COPY);	
	}
}
