import javax.swing.JFrame;

public class DragFrame extends JFrame
{
	DragFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setTitle("Drag and Drop Demo");
		this.setLocationRelativeTo(null);

		ImagePanel submarine = new ImagePanel();
		this.add(submarine);

		this.setVisible(true);
	}
}
