import javax.swing.*;
import java.awt.*;

public class ShipLabel extends JLabel
{
	public ShipLabel(RotatedIcon icon)
	{
		super(icon);
	}

	/*
	@Override
	protected void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		RotatedIcon ship_icon = new RotatedIcon(getIcon());
		//ship_icon.setDegrees(ship_icon.getDegrees() - 90);
		//setIcon(ship_icon);
		ship_icon.paintIcon(this, g2, 0, 0);	
	}
	*/
}
