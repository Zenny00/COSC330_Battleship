//Name(s): Joshua Comfort & Justin Conklin
//Date: 10/5/2022
//Description: Implementation of the view class for the Battleship game GUI
//Water sprite based on: https://www.dreamstime.com/pixel-art-water-background-seamless-sea-texture-backdrop-vector-illustration-image223655049

//Import required libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Point;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import java.awt.Image;

public class View extends JFrame
{
	//					PRIVATE DATA MEMEBERS
	//|====================================================================================================|
	
	//This line is commented for now until view is placed in the same directory as model
	//private dataModel Model;			
	
	//Holds the input and output text
	private JTextField userInput; 
	private JTextArea consoleOut;

	//Array of JButtons for the player's boards
	private JButton playerBoard[][];
	private JButton enemyBoard[][];

	//Array of image icons to hold ships
	private ImageIcon ships[];

	//|====================================================================================================|
	


	//						FUNCTIONS
	//|====================================================================================================|


	//Constructor 
	
	public View()
	{
		ships = new ImageIcon[5];
		playerBoard = new JButton[10][10];
		enemyBoard = new JButton[10][10];
	}

	//Get user input from the JTextField
	public String getUserInput()
	{
		//TODO
		return new String();
	}

	//Display output in JTextArea
	public void printText(String input)
	{
		//TODO
	}

	//Add a tile listener to the tiles
	public void addTileListener(ActionListener fire)
	{
		//TODO
	}

	//Add an icon listener to the ships
	public void addIconListener(ActionListener drag)
	{
		//TODO
	}

	//Remove icon listener from the ships
	public void removeIconListener(ActionListener drag)
	{
		//TODO
	}

	//Draw the graphics
	public void paint(Graphics g)
	{
		//TODO
	}

	//Return JButton at specified location within the grid
	public JButton getJButton(int x, int y)
	{
		//What board are we getting a tile from?
		//TODO
		return new JButton();
	}

	//Update a button at a specified location in the grid
	public void updateButton(int x, int y)
	{
		//TODO
	}

	//Render the ship
	public boolean drawShip(ImageIcon ship)
	{
		//TODO
		return true;
	}
}

//						INNER CLASSES
//|====================================================================================================|

//TODO
