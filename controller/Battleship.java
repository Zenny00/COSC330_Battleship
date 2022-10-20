//Name: Joshua Comfort & Justin Conklin
//Date: 10/3/2022
//Description: Battleship game

package controller;

import model.*;
import view.*;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Scanner;

public class Battleship
{
	public static void main(String args[])
	{
		if (args.length != 1)
		{
			System.out.println("Invalid number of command line arguments, please specify either 'Server' or 'Client'.");
			System.exit(1);
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
				exit(1);
		}

	}

	static void runClient()
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("Please enter the IP address of the game host: ");
		String ip = scanner.nextLine();

		Player player = new Player(new Client(ip));
	}

	static void runServer(){Player player = new Player(new Server());}
}

