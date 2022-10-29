//Name: Joshua Comfort
//Date: 10/10/2022
//Description holds information regarding the server or client

import java.io.IOException;
import java.awt.Point;

public interface Role extends Runnable
{
	//Setup phase
	//public void setup();

	//Send data
	//public void sendData(Object obj);

	//Recieve data
	//public Object receiveData();

	//Setup server
   	public void getStreams() throws IOException;

	//Close connection
   	public void closeConnection();

	//Send and recieve coordinates
   	public void sendMessage(String str);
	public String readMessage();

	public void writeStatus(String str);
	public void resetField();

	//Run the server or client
	public void run();
}
