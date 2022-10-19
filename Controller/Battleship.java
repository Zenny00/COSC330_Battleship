//Name: Joshua Comfort & Justin Conklin
//Date: 10/3/2022
//Description: Battleship game

//Import required libraries
package controller;

import package.model.*;
import package.view.*;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Scanner;

public class Battleship
{
	//void runClient();
	//void runServer();

	public static void main(String args[])
	{
		if (args.length < 1)
		{
			System.out.println("Invalid number of command line arguments, please specify either 'Server' or 'Client'.");
			System.exit(0);
		}

		switch(args[0])
		{
			case "Client":
				runClient();
				break;
			case "Server":
				runServer();
				break;
			default:
				System.out.println("Invalid command line argument, please specify either 'Server' or 'Client'.");
				exit(0);
		}

	}

	//Run the client's code
	static void runClient()
	{
		//Get user input
		Scanner scanner = new Scanner(System.in);
		
		//Print a prompt to get user input
		System.out.printf("Please enter the IP address of the game host: ");
		String ip = scanner.nextLine();

		//application = new Client(ip); // use ip to connect
		//application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//application.runClient(); // run client application
	}

	//Run the server's code
	static void runServer()
	{
		//Create a new object of DragFrame
		View frame = new View();	
		Player player = new Player(frame, new Server());
	}
}

