import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;

public class DragFrame extends JFrame
{
	DragFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setTitle("Drag and Drop Demo");
		this.setLocationRelativeTo(null);
		
		Border br = BorderFactory.createLineBorder(Color.black);
		Container c = getContentPane();
 		//new ImageIcon("./View/Graphics/Ships/Submarine.png");

		ImagePanel destroyer = new ImagePanel("./View/Graphics/Ships/Destroyer.png", 100, 100);
	       	c.add(destroyer);	

		ImagePanel submarine = new ImagePanel("./View/Graphics/Ships/Submarine.png", 100, 300);
		c.add(submarine);

		this.setVisible(true);
	}
}
