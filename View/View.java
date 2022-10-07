//Name(s): Joshua Comfort & Justin Conklin
//Date: 10/5/2022
//Description: Implementation of the view class for the Battleship game GUI
//Water sprite based on: https://www.deviantart.com/oni1ink/art/Tutorial-How-to-draw-Water-645199166

//Import required libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Point;

public class View extends JFrame
{
	//					PRIVATE DATA MEMEBERS
	//|====================================================================================================|
	
	//This line is commented for now until view is placed in the same directory as model
	//private dataModel Model;
	
	//Constants for the number of ships and the size of each board
	private final int BOARD_SIZE = 10;
	private final int NUM_SHIPS = 5;
	
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
		//Setup panels and arrays
		JPanel shipButtonPanel = new JPanel();
		JPanel shipContainerPanel = new JPanel();
		JPanel targetButtonPanel = new JPanel();
		JPanel targetContainerPanel = new JPanel();

		shipButtonPanel.setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));
		targetButtonPanel.setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));

		ships = new ImageIcon[NUM_SHIPS];
		playerBoard = new JButton[BOARD_SIZE][BOARD_SIZE];
		enemyBoard = new JButton[BOARD_SIZE][BOARD_SIZE];

		//Initialize ship board
		int i = 0, j = 0;
		for (JButton[] row: playerBoard)
		{
			for (JButton button: row)
			{
				//Create new button with water icon
				button = new JButton(new ImageIcon("Graphics/Water/Water.png"));
				
				//Set text to coordinates and scale
				button.setText(String.valueOf(i) + " " + String.valueOf(j));
				button.setPreferredSize(new Dimension(30, 30));
				button.setEnabled(false);
				
				//Add JButton to JPanel
				shipButtonPanel.add(button);
				j++;
			}	
			j = 0;
			i++;
		}
		/*
		//Set the button text for the player board
		for (int i = 0; i < BOARD_SIZE; i++)
			for (int j = 0; j < BOARD_SIZE; i++)
				playerBoard[i][j].setText(i + " " + j);
		*/

		shipButtonPanel.setPreferredSize(new Dimension(300, 300));
		shipContainerPanel.add(shipButtonPanel);

		//Initialize 2D array of target board
		i = 0;
		for (JButton[] row: enemyBoard)
		{	
			for (JButton button: row)
			{
				button = new JButton(new ImageIcon("Graphics/Water/Water.png"));
				button.setText(String.valueOf(i) + " " + String.valueOf(j));
				//addTileListener(button);
				button.setPreferredSize(new Dimension(30, 30));
				targetButtonPanel.add(button);
				j++;
			}
			j = 0;
			i++;
		}	

		//Create new ship image icon
		ships[0] = new ImageIcon("Graphics/Ships/Submarine.png");

		targetButtonPanel.setPreferredSize(new Dimension(300, 300));
		targetContainerPanel.add(targetButtonPanel);

		//Configure frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setTitle("BATTLESHIP");
		this.setLocationRelativeTo(null);
	
		//Add panels to content pane	
		this.getContentPane().add(targetContainerPanel);
		this.getContentPane().add(shipContainerPanel);

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		//Pack and set visibility
		this.pack();
		this.setVisible(true);
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
	/*
	public void addTileListener(JButton button)
	{
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String coords[] = button.getText().split(" ");
				Point point = new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
                		System.out.println(point.getX() + " " + point.getY());
            		}
        	});
	}
	*/

	public void addFireListener(ActionListener fire)
	{
		//Iterate through the 2D array of tiles and add fire listener to each JButton
		
		enemyBoard[0][0].addActionListener(fire);
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
