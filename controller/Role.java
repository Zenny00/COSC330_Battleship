//Name: Joshua Comfort
//Date: 10/10/2022
//Description holds information regarding the server or client
package controller;

import model.*;
import view.*;

public interface Role
{
	//Setup phase
	//public void setup();

	//Send data
	public void sendData(Object obj);

	//Recieve data
	//public Object receiveData();

	public void runServer();
}
