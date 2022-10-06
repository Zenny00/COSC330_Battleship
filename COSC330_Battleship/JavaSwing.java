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
		ImageIcon sub_icon = new ImageIcon("/home/jcomfort1/COSC330/Project1/View/Graphics/Ships/Submarine.png");
		ImageIcon destroyer_icon = new ImageIcon("/home/jcomfort1/COSC330/Project1/View/Graphics/Ships/Destroyer.png");
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(200, 300);
		JLabel lbl = new JLabel();
<<<<<<< HEAD
		JLabel lbl2 = new JLabel();
		lbl.setIcon(sub_icon);
		lbl2.setIcon(destroyer_icon);
		frame.add(lbl);
		frame.add(lbl2);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
=======
		//JButton button = new JButton("Exit");
>>>>>>> b6bf551aee8d95b9501bc629d9bfe723d8cf95ca


		//JPanel frame = new JPanel();
		button.setBounds(200, 100, 100, 40);
		

		frame.setSize(500, 500);
		frame.setBackground(Color.BLUE);
		JLabel label = new JLabel();
		label.setIcon(icon);
		frame.add(label);
		this.getContentPane().add(frame);
		frame.setLayout(null);
		frame.add(button);
		lbl.setIcon(icon);
		frame.add(lbl);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
