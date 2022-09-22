import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.net.URL;
//from   ww  w . j a v a 2  s  . co m
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;

public class JavaSwing
{
	
	public static void main(String[] args)
	{
		ImageIcon icon = new ImageIcon(new ImageIcon("/home/jcomfort1/COSC330/Project1/View/Graphics/Ships/Submarine.png").getImage().getScaledInstance(22, 87, Image.SCALE_DEFAULT));
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(200, 300);
		JLabel lbl = new JLabel();
		lbl.setIcon(icon);
		frame.add(lbl);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	public JavaSwing()
	{
		JPanel frame = new JPanel();
		JButton button = new JButton("Exit");
		button.setBounds(200, 100, 100, 40);
		
		frame.add(button);

		frame.setSize(500, 500);
		frame.setBackground(Color.BLUE);
		ImageIcon icon = new ImageIcon		JLabel label = new JLabel();
		label.setIcon(icon);
		frame.add(label);
		this.getContentPane().add(frame);
		frame.setLayout(null);
	}
	*/
}
