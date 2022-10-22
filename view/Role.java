//Name: Joshua Comfort
//Date: 10/10/2022
//Description holds information regarding the server or client

import java.awt.Point;

public interface Role
{
	//Setup phase
	//public void setup();

	//Send data
	public void sendData(Object obj);

	//Recieve data
	//public Object receiveData();

	//Send and recieve coordinates
   	public void sendCoordinates(String str);
	public String getCoordinates();

	public void run();
}
