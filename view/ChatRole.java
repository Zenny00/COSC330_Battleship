//Name: Joshua Comfort
//Date: 10/10/2022
//Description holds information regarding the server or client

import java.io.IOException;
import java.awt.Point;

public interface ChatRole extends Runnable
{
	//Run the server or client
	public void run();
}
