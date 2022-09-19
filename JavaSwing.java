import javax.swing.*;

public class JavaSwing
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		JButton button = new JButton("Exit");
		button.setBounds(200, 100, 100, 40);

		frame.add(button);

		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
