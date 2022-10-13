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
	private JButton playerBoard[][] = new JButton[BOARD_SIZE][BOARD_SIZE];
	private JButton enemyBoard[][] = new JButton[BOARD_SIZE][BOARD_SIZE];

	//Array of image icons to hold ships
	private ImageIcon ships[] = new ImageIcon[NUM_SHIPS];

	//Setup panels and arrays
	private JPanel shipButtonPanel = new JPanel();
	private JPanel shipContainerPanel = new JPanel();
	private JPanel targetButtonPanel = new JPanel();
	private JPanel targetContainerPanel = new JPanel();

	//Init JButton | MUST BE DONE BEFORE CONSTRUCTOR!"
	private JButton i0j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i0j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i0j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i0j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i0j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i0j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i0j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i0j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i0j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i0j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i1j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i1j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i1j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i1j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i1j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i1j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i1j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i1j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i1j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i1j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i2j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i2j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i2j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i2j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i2j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i2j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i2j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i2j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i2j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i2j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i3j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i3j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i3j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i3j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i3j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i3j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i3j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i3j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i3j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i3j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i4j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i4j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i4j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i4j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i4j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i4j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i4j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i4j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i4j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i4j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i5j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i5j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i5j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i5j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i5j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i5j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i5j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i5j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i5j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i5j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i6j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i6j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i6j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i6j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i6j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i6j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i6j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i6j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i6j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i6j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i7j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i7j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i7j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i7j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i7j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i7j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i7j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i7j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i7j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i7j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i8j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i8j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i8j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i8j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i8j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i8j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i8j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i8j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i8j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i8j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i9j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i9j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i9j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i9j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i9j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i9j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i9j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i9j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i9j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton i9j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));		
	
	//|====================================================================================================|
	


	//						FUNCTIONS
	//|====================================================================================================|


	//Constructor 
	public View()
	{
		//Setup for Jpanels
		shipButtonPanel.setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));
		targetButtonPanel.setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));	
		shipButtonPanel.setPreferredSize(new Dimension(300, 300));
		shipContainerPanel.add(shipButtonPanel);
		targetButtonPanel.setPreferredSize(new Dimension(300, 300));
		targetContainerPanel.add(targetButtonPanel);

		i0j0.setHorizontalTextPosition(JButton.CENTER);
		i0j0.setVerticalTextPosition(JButton.CENTER);
		//Setup enemy board
		assignEnemyBoard();

		//Initialize 2D array for boards
		initJButtons();
		//addTileListener(new TileListener()); 

		//Create new ship image icon
		ships[0] = new ImageIcon("Graphics/Ships/Submarine.png");

		//Configure frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setTitle("BATTLESHIP");
		this.setLocationRelativeTo(null);
	
		//Add panels to content pane	
		this.getContentPane().add(targetContainerPanel);
		this.getContentPane().add(shipContainerPanel);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	}

	//Adds JPanel to view
	public void addJPanel(Role panel)
	{
		getContentPane().add(((JPanel)panel));		
	}

	//Setup frame by packing and setting visibility
	public void setupView()
	{
		//Pack and set visibility
		pack();
		setVisible(true);
	}


	public void initJButtons()
	{
		int i = 0, j = 0;
		for (JButton[] row: playerBoard)
		{
			for (JButton button: row)
			{
				//Create new button with water icon
				button = new JButton(new ImageIcon("Graphics/Water/Water.png"));
				
				//Set text to coordinates and scale
				//button.setText(String.valueOf(i) + " " + String.valueOf(j));
				button.setActionCommand(String.valueOf(i) + " " + String.valueOf(j));
				button.setPreferredSize(new Dimension(30, 30));
				//button.setEnabled(false);
				
				//Add JButton to JPanel
				shipButtonPanel.add(button);
				j++;
			}	
			j = 0;
			i++;
		}

		i = 0;
		for (JButton[] row: enemyBoard)
		{	
			for (JButton button: row)
			{
				//button = new JButton(new ImageIcon("Graphics/Water/Water.png"));
				//button.setText(String.valueOf(i) + " " + String.valueOf(j));
				button.setActionCommand(String.valueOf(i) + " " + String.valueOf(j));
				//addTileListener(button);
				button.setPreferredSize(new Dimension(30, 30));
				targetButtonPanel.add(button);
				j++;
			}
			j = 0;
			i++;
		}
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
		//Iterate through the 2D array of tiles and add a tile listener to each JButton
		for (JButton[] row: enemyBoard)	
			for (JButton button: row)
				button.addActionListener(fire);
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

	private void assignEnemyBoard()
	{
		//Setup enemyBoard with init JButtons
		enemyBoard[0][0] = i0j0;
		enemyBoard[0][1] = i0j1;
		enemyBoard[0][2] = i0j2;
		enemyBoard[0][3] = i0j3;
		enemyBoard[0][4] = i0j4;
		enemyBoard[0][5] = i0j5;
		enemyBoard[0][6] = i0j6;
		enemyBoard[0][7] = i0j7;
		enemyBoard[0][8] = i0j8;
		enemyBoard[0][9] = i0j9;
		enemyBoard[1][0] = i1j0;
		enemyBoard[1][1] = i1j1;
		enemyBoard[1][2] = i1j2;
		enemyBoard[1][3] = i1j3;
		enemyBoard[1][4] = i1j4;
		enemyBoard[1][5] = i1j5;
		enemyBoard[1][6] = i1j6;
		enemyBoard[1][7] = i1j7;
		enemyBoard[1][8] = i1j8;
		enemyBoard[1][9] = i1j9;
		enemyBoard[2][0] = i2j0;
		enemyBoard[2][1] = i2j1;
		enemyBoard[2][2] = i2j2;
		enemyBoard[2][3] = i2j3;
		enemyBoard[2][4] = i2j4;
		enemyBoard[2][5] = i2j5;
		enemyBoard[2][6] = i2j6;
		enemyBoard[2][7] = i2j7;
		enemyBoard[2][8] = i2j8;
		enemyBoard[2][9] = i2j9;
		enemyBoard[3][0] = i3j0;
		enemyBoard[3][1] = i3j1;
		enemyBoard[3][2] = i3j2;
		enemyBoard[3][3] = i3j3;
		enemyBoard[3][4] = i3j4;
		enemyBoard[3][5] = i3j5;
		enemyBoard[3][6] = i3j6;
		enemyBoard[3][7] = i3j7;
		enemyBoard[3][8] = i3j8;
		enemyBoard[3][9] = i3j9;
		enemyBoard[4][0] = i4j0;
		enemyBoard[4][1] = i4j1;
		enemyBoard[4][2] = i4j2;
		enemyBoard[4][3] = i4j3;
		enemyBoard[4][4] = i4j4;
		enemyBoard[4][5] = i4j5;
		enemyBoard[4][6] = i4j6;
		enemyBoard[4][7] = i4j7;
		enemyBoard[4][8] = i4j8;
		enemyBoard[4][9] = i4j9;
		enemyBoard[5][0] = i5j0;
		enemyBoard[5][1] = i5j1;
		enemyBoard[5][2] = i5j2;
		enemyBoard[5][3] = i5j3;
		enemyBoard[5][4] = i5j4;
		enemyBoard[5][5] = i5j5;
		enemyBoard[5][6] = i5j6;
		enemyBoard[5][7] = i5j7;
		enemyBoard[5][8] = i5j8;
		enemyBoard[5][9] = i5j9;
		enemyBoard[6][0] = i6j0;
		enemyBoard[6][1] = i6j1;
		enemyBoard[6][2] = i6j2;
		enemyBoard[6][3] = i6j3;
		enemyBoard[6][4] = i6j4;
		enemyBoard[6][5] = i6j5;
		enemyBoard[6][6] = i6j6;
		enemyBoard[6][7] = i6j7;
		enemyBoard[6][8] = i6j8;
		enemyBoard[6][9] = i6j9;
		enemyBoard[7][0] = i7j0;
		enemyBoard[7][1] = i7j1;
		enemyBoard[7][2] = i7j2;
		enemyBoard[7][3] = i7j3;
		enemyBoard[7][4] = i7j4;
		enemyBoard[7][5] = i7j5;
		enemyBoard[7][6] = i7j6;
		enemyBoard[7][7] = i7j7;
		enemyBoard[7][8] = i7j8;
		enemyBoard[7][9] = i7j9;
		enemyBoard[8][0] = i8j0;
		enemyBoard[8][1] = i8j1;
		enemyBoard[8][2] = i8j2;
		enemyBoard[8][3] = i8j3;
		enemyBoard[8][4] = i8j4;
		enemyBoard[8][5] = i8j5;
		enemyBoard[8][6] = i8j6;
		enemyBoard[8][7] = i8j7;
		enemyBoard[8][8] = i8j8;
		enemyBoard[8][9] = i8j9;
		enemyBoard[9][0] = i9j0;
		enemyBoard[9][1] = i9j1;
		enemyBoard[9][2] = i9j2;
		enemyBoard[9][3] = i9j3;
		enemyBoard[9][4] = i9j4;
		enemyBoard[9][5] = i9j5;
		enemyBoard[9][6] = i9j6;
		enemyBoard[9][7] = i9j7;
		enemyBoard[9][8] = i9j8;
		enemyBoard[9][9] = i9j9;
	}

//						INNER CLASSES
//|====================================================================================================|	
}
