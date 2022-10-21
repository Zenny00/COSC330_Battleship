//Name(s): Joshua Comfort & Justin Conklin
//Date: 10/5/2022
//Description: Implementation of the view class for the Battleship game GUI
//Water sprite based on: https://www.deviantart.com/oni1ink/art/Tutorial-How-to-draw-Water-645199166
//Ship sprites inspired by: Lowder2 - https://opengameart.org/content/sea-warfare-set-ships-and-more

//Import required libraries
import javax.swing.*;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.*;
import javax.swing.border.*;
import java.lang.Math;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.concurrent.ThreadLocalRandom;

public class View extends JFrame
{
	//					PRIVATE DATA MEMEBERS
	//|====================================================================================================|
		
	//Constants for the number of ships and the size of each board
	private final int BOARD_SIZE = 10;
	private final int NUM_SHIPS = 5;

	//View model data member	
	private Model model;

	//Holds the input and output text
	private JTextField userInput; 
	private JTextArea consoleOut;

	//Array of JButtons for the player's boards
	private JButton playerBoard[][] = new JButton[BOARD_SIZE][BOARD_SIZE];
	private JButton targetBoard[][] = new JButton[BOARD_SIZE][BOARD_SIZE];

	//Array of image icons to hold ships
	private JPanel ships[] = new JPanel[NUM_SHIPS];

	//Setup panels and arrays
	private JPanel shipButtonPanel = new JPanel();
	private JPanel shipContainerPanel = new JPanel();
	private JPanel targetButtonPanel = new JPanel();
	private JPanel targetContainerPanel = new JPanel();

	private JPanel shipBox = new JPanel();

	//Ships
	//Create label data members to store the ships
	private JLabel des;
	private JLabel sub;
	private JLabel cru;
	private JLabel bat;
	private JLabel car;
		
	//Init JButton | MUST BE DONE BEFORE CONSTRUCTOR!"
	private JButton ship_i0j0= new JButton();
	private JButton ship_i0j1= new JButton();
	private JButton ship_i0j2= new JButton();
	private JButton ship_i0j3= new JButton();
	private JButton ship_i0j4= new JButton();
	private JButton ship_i0j5= new JButton();
	private JButton ship_i0j6= new JButton();
	private JButton ship_i0j7= new JButton();
	private JButton ship_i0j8= new JButton();
	private JButton ship_i0j9= new JButton();
	private JButton ship_i1j0= new JButton();
	private JButton ship_i1j1= new JButton();
	private JButton ship_i1j2= new JButton();
	private JButton ship_i1j3= new JButton();
	private JButton ship_i1j4= new JButton();
	private JButton ship_i1j5= new JButton();
	private JButton ship_i1j6= new JButton();
	private JButton ship_i1j7= new JButton();
	private JButton ship_i1j8= new JButton();
	private JButton ship_i1j9= new JButton();
	private JButton ship_i2j0= new JButton();
	private JButton ship_i2j1= new JButton();
	private JButton ship_i2j2= new JButton();
	private JButton ship_i2j3= new JButton();
	private JButton ship_i2j4= new JButton();
	private JButton ship_i2j5= new JButton();
	private JButton ship_i2j6= new JButton();
	private JButton ship_i2j7= new JButton();
	private JButton ship_i2j8= new JButton();
	private JButton ship_i2j9= new JButton();
	private JButton ship_i3j0= new JButton();
	private JButton ship_i3j1= new JButton();
	private JButton ship_i3j2= new JButton();
	private JButton ship_i3j3= new JButton();
	private JButton ship_i3j4= new JButton();
	private JButton ship_i3j5= new JButton();
	private JButton ship_i3j6= new JButton();
	private JButton ship_i3j7= new JButton();
	private JButton ship_i3j8= new JButton();
	private JButton ship_i3j9= new JButton();
	private JButton ship_i4j0= new JButton();
	private JButton ship_i4j1= new JButton();
	private JButton ship_i4j2= new JButton();
	private JButton ship_i4j3= new JButton();
	private JButton ship_i4j4= new JButton();
	private JButton ship_i4j5= new JButton();
	private JButton ship_i4j6= new JButton();
	private JButton ship_i4j7= new JButton();
	private JButton ship_i4j8= new JButton();
	private JButton ship_i4j9= new JButton();
	private JButton ship_i5j0= new JButton();
	private JButton ship_i5j1= new JButton();
	private JButton ship_i5j2= new JButton();
	private JButton ship_i5j3= new JButton();
	private JButton ship_i5j4= new JButton();
	private JButton ship_i5j5= new JButton();
	private JButton ship_i5j6= new JButton();
	private JButton ship_i5j7= new JButton();
	private JButton ship_i5j8= new JButton();
	private JButton ship_i5j9= new JButton();
	private JButton ship_i6j0= new JButton();
	private JButton ship_i6j1= new JButton();
	private JButton ship_i6j2= new JButton();
	private JButton ship_i6j3= new JButton();
	private JButton ship_i6j4= new JButton();
	private JButton ship_i6j5= new JButton();
	private JButton ship_i6j6= new JButton();
	private JButton ship_i6j7= new JButton();
	private JButton ship_i6j8= new JButton();
	private JButton ship_i6j9= new JButton();
	private JButton ship_i7j0= new JButton();
	private JButton ship_i7j1= new JButton();
	private JButton ship_i7j2= new JButton();
	private JButton ship_i7j3= new JButton();
	private JButton ship_i7j4= new JButton();
	private JButton ship_i7j5= new JButton();
	private JButton ship_i7j6= new JButton();
	private JButton ship_i7j7= new JButton();
	private JButton ship_i7j8= new JButton();
	private JButton ship_i7j9= new JButton();
	private JButton ship_i8j0= new JButton();
	private JButton ship_i8j1= new JButton();
	private JButton ship_i8j2= new JButton();
	private JButton ship_i8j3= new JButton();
	private JButton ship_i8j4= new JButton();
	private JButton ship_i8j5= new JButton();
	private JButton ship_i8j6= new JButton();
	private JButton ship_i8j7= new JButton();
	private JButton ship_i8j8= new JButton();
	private JButton ship_i8j9= new JButton();
	private JButton ship_i9j0= new JButton();
	private JButton ship_i9j1= new JButton();
	private JButton ship_i9j2= new JButton();
	private JButton ship_i9j3= new JButton();
	private JButton ship_i9j4= new JButton();
	private JButton ship_i9j5= new JButton();
	private JButton ship_i9j6= new JButton();
	private JButton ship_i9j7= new JButton();
	private JButton ship_i9j8= new JButton();
	private JButton ship_i9j9= new JButton();
	private JButton target_i0j0= new JButton();
	private JButton target_i0j1= new JButton();
	private JButton target_i0j2= new JButton();
	private JButton target_i0j3= new JButton();
	private JButton target_i0j4= new JButton();
	private JButton target_i0j5= new JButton();
	private JButton target_i0j6= new JButton();
	private JButton target_i0j7= new JButton();
	private JButton target_i0j8= new JButton();
	private JButton target_i0j9= new JButton();
	private JButton target_i1j0= new JButton();
	private JButton target_i1j1= new JButton();
	private JButton target_i1j2= new JButton();
	private JButton target_i1j3= new JButton();
	private JButton target_i1j4= new JButton();
	private JButton target_i1j5= new JButton();
	private JButton target_i1j6= new JButton();
	private JButton target_i1j7= new JButton();
	private JButton target_i1j8= new JButton();
	private JButton target_i1j9= new JButton();
	private JButton target_i2j0= new JButton();
	private JButton target_i2j1= new JButton();
	private JButton target_i2j2= new JButton();
	private JButton target_i2j3= new JButton();
	private JButton target_i2j4= new JButton();
	private JButton target_i2j5= new JButton();
	private JButton target_i2j6= new JButton();
	private JButton target_i2j7= new JButton();
	private JButton target_i2j8= new JButton();
	private JButton target_i2j9= new JButton();
	private JButton target_i3j0= new JButton();
	private JButton target_i3j1= new JButton();
	private JButton target_i3j2= new JButton();
	private JButton target_i3j3= new JButton();
	private JButton target_i3j4= new JButton();
	private JButton target_i3j5= new JButton();
	private JButton target_i3j6= new JButton();
	private JButton target_i3j7= new JButton();
	private JButton target_i3j8= new JButton();
	private JButton target_i3j9= new JButton();
	private JButton target_i4j0= new JButton();
	private JButton target_i4j1= new JButton();
	private JButton target_i4j2= new JButton();
	private JButton target_i4j3= new JButton();
	private JButton target_i4j4= new JButton();
	private JButton target_i4j5= new JButton();
	private JButton target_i4j6= new JButton();
	private JButton target_i4j7= new JButton();
	private JButton target_i4j8= new JButton();
	private JButton target_i4j9= new JButton();
	private JButton target_i5j0= new JButton();
	private JButton target_i5j1= new JButton();
	private JButton target_i5j2= new JButton();
	private JButton target_i5j3= new JButton();
	private JButton target_i5j4= new JButton();
	private JButton target_i5j5= new JButton();
	private JButton target_i5j6= new JButton();
	private JButton target_i5j7= new JButton();
	private JButton target_i5j8= new JButton();
	private JButton target_i5j9= new JButton();
	private JButton target_i6j0= new JButton();
	private JButton target_i6j1= new JButton();
	private JButton target_i6j2= new JButton();
	private JButton target_i6j3= new JButton();
	private JButton target_i6j4= new JButton();
	private JButton target_i6j5= new JButton();
	private JButton target_i6j6= new JButton();
	private JButton target_i6j7= new JButton();
	private JButton target_i6j8= new JButton();
	private JButton target_i6j9= new JButton();
	private JButton target_i7j0= new JButton();
	private JButton target_i7j1= new JButton();
	private JButton target_i7j2= new JButton();
	private JButton target_i7j3= new JButton();
	private JButton target_i7j4= new JButton();
	private JButton target_i7j5= new JButton();
	private JButton target_i7j6= new JButton();
	private JButton target_i7j7= new JButton();
	private JButton target_i7j8= new JButton();
	private JButton target_i7j9= new JButton();
	private JButton target_i8j0= new JButton();
	private JButton target_i8j1= new JButton();
	private JButton target_i8j2= new JButton();
	private JButton target_i8j3= new JButton();
	private JButton target_i8j4= new JButton();
	private JButton target_i8j5= new JButton();
	private JButton target_i8j6= new JButton();
	private JButton target_i8j7= new JButton();
	private JButton target_i8j8= new JButton();
	private JButton target_i8j9= new JButton();
	private JButton target_i9j0= new JButton();
	private JButton target_i9j1= new JButton();
	private JButton target_i9j2= new JButton();
	private JButton target_i9j3= new JButton();
	private JButton target_i9j4= new JButton();
	private JButton target_i9j5= new JButton();
	private JButton target_i9j6= new JButton();
	private JButton target_i9j7= new JButton();
	private JButton target_i9j8= new JButton();
	private JButton target_i9j9= new JButton();	

	//Setup new JButton to allow the user to randomize their ships
	private JButton setup_random = new JButton();	

	//|=====================================================================================================|
	//|													|
	//|						FUNCTIONS						|
	//|													|
	//|=====================================================================================================|

	//Constructor 
	public View(Model model, Role connect_panel)
	{	
		//Set the model
		this.model = model;

		//Setup main grid
		GridLayout contentLayout = new GridLayout(2, 2);
		contentLayout.setVgap(10);
		contentLayout.setHgap(10);
		
		//Set layout format
		getContentPane().setLayout(contentLayout);
		shipButtonPanel.setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));
		targetButtonPanel.setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));	
		
		//Setup size configurations
		shipButtonPanel.setPreferredSize(new Dimension(300, 300));
		shipContainerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		targetButtonPanel.setPreferredSize(new Dimension(300, 300));
		targetContainerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		//Add JPanels to containers
		shipContainerPanel.add(shipButtonPanel);
		targetContainerPanel.add(targetButtonPanel);
		
		//Setup boards
		assignEnemyBoard();
		assignPlayerBoard();
	
		//				--- CONFIGURE SHIPS ---
		// |------------------------------------------------------------------------------------|
		// | 1. Destroyer									|
		// | 2. Submarine									|
		// | 3. Cruiser										|
		// | 4. Battleship									|
		// | 5. Carrier										|
		// |------------------------------------------------------------------------------------|
	
		//Ship label objs to hold the ship icons and actions
		des = new DesLabel(2, 0, "Graphics/Ships/Destroyer.png", "Graphics/Ships/DestroyerLeft.png");
		sub = new SubLabel(3, 0, "Graphics/Ships/Submarine.png", "Graphics/Ships/SubmarineLeft.png");	
		cru = new CruLabel(3, 0, "Graphics/Ships/Cruiser.png", "Graphics/Ships/CruiserLeft.png");	
		bat = new BatLabel(4, 0, "Graphics/Ships/Battleship.png", "Graphics/Ships/BattleshipLeft.png");
		car = new CarLabel(5, 0, "Graphics/Ships/Carrier.png", "Graphics/Ships/CarrierLeft.png");

		//Create new mouse action handlers
		DragShip drag_des = new DragShip();
		DragShip drag_sub = new DragShip();
		DragShip drag_cru = new DragShip();
		DragShip drag_bat = new DragShip();
		DragShip drag_car = new DragShip();
		
		//Add action handlers to the ship labels
		des.addMouseListener(drag_des);
		des.addMouseMotionListener(drag_des);
		sub.addMouseListener(drag_sub);
		sub.addMouseMotionListener(drag_sub);
		cru.addMouseListener(drag_cru);
		cru.addMouseMotionListener(drag_cru);
		bat.addMouseListener(drag_bat);
		bat.addMouseMotionListener(drag_bat);
		car.addMouseListener(drag_car);
		car.addMouseMotionListener(drag_car);
				
		//Initialize 2D array for boards
		//Try to initialize JButtons
		try
		{
			initJButtons(drag_des, drag_sub, drag_cru, drag_bat, drag_car);
		}
		catch (IOException ex)
		{
			System.out.println(ex.toString());
		}

		//Setup randomize button

		setup_random.setPreferredSize(new Dimension(60, 30));
		setup_random.setText("Randomize");
		setup_random.addActionListener(new RandomSetupListener());

		//Add ships to the content pane
		shipBox.add(des);
		shipBox.add(sub);
		shipBox.add(cru);
		shipBox.add(bat);
		shipBox.add(car);
		shipBox.add(setup_random);
	
		//Setup colors
		shipBox.setBackground(new Color(0, 0, 80));
		this.getContentPane().setBackground(new Color(0, 0, 0));
		targetContainerPanel.setBackground(new Color(0, 0, 0));
		shipContainerPanel.setBackground(new Color(0, 0, 0));

		//Give button gold border and background to light blue
		setup_random.setBorder(new LineBorder(new Color(232, 167, 17)));
		setup_random.setBackground(new Color(51, 153, 255));
		setup_random.setOpaque(true);

		//Setup shipbox for holding ships
		shipBox.setLayout(new GridLayout(1, 6));

		//Configure frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setTitle("BATTLESHIP");
		this.setLocationRelativeTo(null);
	
		//Add panels to content pane	
		this.getContentPane().add(targetContainerPanel);
		this.getContentPane().add(((JPanel)connect_panel));
		this.getContentPane().add(shipContainerPanel);
		this.getContentPane().add(shipBox);
			
		//Pack and set visibility
		pack();
		setVisible(true);
	}

	public ImageIcon scaleImage(ImageIcon icon, int w, int h)
	{
		int nw = icon.getIconWidth();
		int nh = icon.getIconHeight();

		if(icon.getIconWidth() > w)
		{
			nw = w;
			nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
		}

		if(nh > h)
		{
			nh = h;
			nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
		}

		return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
	}		

	public void initJButtons(DragShip drag_des, DragShip drag_sub, DragShip drag_cru, DragShip drag_bat, DragShip drag_car) throws IOException 
	{
		//Load water icon
		Icon water_icon = sourceIcon("Graphics/Water/Water.png");
	
		//Varibles to adding index to buttons	
		int x = 0, y = 0;
		for (JButton[] row: playerBoard)
		{
			for (JButton button: row)
			{
				//Set command to coordinates and scale
				button.setActionCommand(String.valueOf(x) + " " + String.valueOf(y));
				button.setPreferredSize(new Dimension(30, 30));
				
				//Add proper action listeners to the tiles
				button.addMouseListener(drag_des);
				button.addMouseListener(drag_sub);
				button.addMouseListener(drag_cru);
				button.addMouseListener(drag_bat);
				button.addMouseListener(drag_car);
				
				//Set up the image icon
				button.setIcon(water_icon);
				
				//Add JButton to JPanel
				shipButtonPanel.add(button);
				x++;
			}	
			x = 0;
			y++;
		}

		x = 0;
		for (JButton[] row: targetBoard)
		{	
			for (JButton button: row)
			{
				button.setActionCommand(String.valueOf(x) + " " + String.valueOf(y));
				button.setPreferredSize(new Dimension(30, 30));
				
				//Set up the image icon
				button.setIcon(water_icon);
				targetButtonPanel.add(button);
				x++;
			}
			x = 0;
			y++;
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
		for (JButton[] row: targetBoard)	
			for (JButton button: row)
				button.addActionListener(fire);
	}
	
	//Return JButton at specified location within the grid
	public JButton getTargetButton(int x, int y)
	{
		return targetBoard[x][y];	
	}

	//Return JButton at specified location within the grid
	public JButton getShipButton(int x, int y)
	{
		return playerBoard[x][y];	
	}

	//Update a button at a specified location in the grid
	public void updateButton(int x, int y)
	{
		//TODO
	}

	//Getters for the JPanels holding the water and ship tiles
	public JPanel getTargetPanel() {return targetButtonPanel;}
	public JPanel getShipPanel() {return shipButtonPanel;}

	private void assignEnemyBoard()
	{
		//Setup enemyBoard with init JButtons
		targetBoard[0][0] = target_i0j0;
		targetBoard[0][1] = target_i0j1;
		targetBoard[0][2] = target_i0j2;
		targetBoard[0][3] = target_i0j3;
		targetBoard[0][4] = target_i0j4;
		targetBoard[0][5] = target_i0j5;
		targetBoard[0][6] = target_i0j6;
		targetBoard[0][7] = target_i0j7;
		targetBoard[0][8] = target_i0j8;
		targetBoard[0][9] = target_i0j9;
		targetBoard[1][0] = target_i1j0;
		targetBoard[1][1] = target_i1j1;
		targetBoard[1][2] = target_i1j2;
		targetBoard[1][3] = target_i1j3;
		targetBoard[1][4] = target_i1j4;
		targetBoard[1][5] = target_i1j5;
		targetBoard[1][6] = target_i1j6;
		targetBoard[1][7] = target_i1j7;
		targetBoard[1][8] = target_i1j8;
		targetBoard[1][9] = target_i1j9;
		targetBoard[2][0] = target_i2j0;
		targetBoard[2][1] = target_i2j1;
		targetBoard[2][2] = target_i2j2;
		targetBoard[2][3] = target_i2j3;
		targetBoard[2][4] = target_i2j4;
		targetBoard[2][5] = target_i2j5;
		targetBoard[2][6] = target_i2j6;
		targetBoard[2][7] = target_i2j7;
		targetBoard[2][8] = target_i2j8;
		targetBoard[2][9] = target_i2j9;
		targetBoard[3][0] = target_i3j0;
		targetBoard[3][1] = target_i3j1;
		targetBoard[3][2] = target_i3j2;
		targetBoard[3][3] = target_i3j3;
		targetBoard[3][4] = target_i3j4;
		targetBoard[3][5] = target_i3j5;
		targetBoard[3][6] = target_i3j6;
		targetBoard[3][7] = target_i3j7;
		targetBoard[3][8] = target_i3j8;
		targetBoard[3][9] = target_i3j9;
		targetBoard[4][0] = target_i4j0;
		targetBoard[4][1] = target_i4j1;
		targetBoard[4][2] = target_i4j2;
		targetBoard[4][3] = target_i4j3;
		targetBoard[4][4] = target_i4j4;
		targetBoard[4][5] = target_i4j5;
		targetBoard[4][6] = target_i4j6;
		targetBoard[4][7] = target_i4j7;
		targetBoard[4][8] = target_i4j8;
		targetBoard[4][9] = target_i4j9;
		targetBoard[5][0] = target_i5j0;
		targetBoard[5][1] = target_i5j1;
		targetBoard[5][2] = target_i5j2;
		targetBoard[5][3] = target_i5j3;
		targetBoard[5][4] = target_i5j4;
		targetBoard[5][5] = target_i5j5;
		targetBoard[5][6] = target_i5j6;
		targetBoard[5][7] = target_i5j7;
		targetBoard[5][8] = target_i5j8;
		targetBoard[5][9] = target_i5j9;
		targetBoard[6][0] = target_i6j0;
		targetBoard[6][1] = target_i6j1;
		targetBoard[6][2] = target_i6j2;
		targetBoard[6][3] = target_i6j3;
		targetBoard[6][4] = target_i6j4;
		targetBoard[6][5] = target_i6j5;
		targetBoard[6][6] = target_i6j6;
		targetBoard[6][7] = target_i6j7;
		targetBoard[6][8] = target_i6j8;
		targetBoard[6][9] = target_i6j9;
		targetBoard[7][0] = target_i7j0;
		targetBoard[7][1] = target_i7j1;
		targetBoard[7][2] = target_i7j2;
		targetBoard[7][3] = target_i7j3;
		targetBoard[7][4] = target_i7j4;
		targetBoard[7][5] = target_i7j5;
		targetBoard[7][6] = target_i7j6;
		targetBoard[7][7] = target_i7j7;
		targetBoard[7][8] = target_i7j8;
		targetBoard[7][9] = target_i7j9;
		targetBoard[8][0] = target_i8j0;
		targetBoard[8][1] = target_i8j1;
		targetBoard[8][2] = target_i8j2;
		targetBoard[8][3] = target_i8j3;
		targetBoard[8][4] = target_i8j4;
		targetBoard[8][5] = target_i8j5;
		targetBoard[8][6] = target_i8j6;
		targetBoard[8][7] = target_i8j7;
		targetBoard[8][8] = target_i8j8;
		targetBoard[8][9] = target_i8j9;
		targetBoard[9][0] = target_i9j0;
		targetBoard[9][1] = target_i9j1;
		targetBoard[9][2] = target_i9j2;
		targetBoard[9][3] = target_i9j3;
		targetBoard[9][4] = target_i9j4;
		targetBoard[9][5] = target_i9j5;
		targetBoard[9][6] = target_i9j6;
		targetBoard[9][7] = target_i9j7;
		targetBoard[9][8] = target_i9j8;
		targetBoard[9][9] = target_i9j9;	
	}

	private void assignPlayerBoard()
	{
		//Setup playerBoard with init JButtons
		playerBoard[0][0] = ship_i0j0;
                playerBoard[0][1] = ship_i0j1;
                playerBoard[0][2] = ship_i0j2;
                playerBoard[0][3] = ship_i0j3;
                playerBoard[0][4] = ship_i0j4;
                playerBoard[0][5] = ship_i0j5;
                playerBoard[0][6] = ship_i0j6;
                playerBoard[0][7] = ship_i0j7;
                playerBoard[0][8] = ship_i0j8;
                playerBoard[0][9] = ship_i0j9;
                playerBoard[1][0] = ship_i1j0;
                playerBoard[1][1] = ship_i1j1;
                playerBoard[1][2] = ship_i1j2;
                playerBoard[1][3] = ship_i1j3;
                playerBoard[1][4] = ship_i1j4;
                playerBoard[1][5] = ship_i1j5;
                playerBoard[1][6] = ship_i1j6;
                playerBoard[1][7] = ship_i1j7;
                playerBoard[1][8] = ship_i1j8;
                playerBoard[1][9] = ship_i1j9;
                playerBoard[2][0] = ship_i2j0;
                playerBoard[2][1] = ship_i2j1;
                playerBoard[2][2] = ship_i2j2;
                playerBoard[2][3] = ship_i2j3;
                playerBoard[2][4] = ship_i2j4;
                playerBoard[2][5] = ship_i2j5;
                playerBoard[2][6] = ship_i2j6;
                playerBoard[2][7] = ship_i2j7;
                playerBoard[2][8] = ship_i2j8;
                playerBoard[2][9] = ship_i2j9;
                playerBoard[3][0] = ship_i3j0;
                playerBoard[3][1] = ship_i3j1;
                playerBoard[3][2] = ship_i3j2;
                playerBoard[3][3] = ship_i3j3;
                playerBoard[3][4] = ship_i3j4;
                playerBoard[3][5] = ship_i3j5;
                playerBoard[3][6] = ship_i3j6;
                playerBoard[3][7] = ship_i3j7;
                playerBoard[3][8] = ship_i3j8;
                playerBoard[3][9] = ship_i3j9;
                playerBoard[4][0] = ship_i4j0;
                playerBoard[4][1] = ship_i4j1;
                playerBoard[4][2] = ship_i4j2;
                playerBoard[4][3] = ship_i4j3;
                playerBoard[4][4] = ship_i4j4;
                playerBoard[4][5] = ship_i4j5;
                playerBoard[4][6] = ship_i4j6;
                playerBoard[4][7] = ship_i4j7;
                playerBoard[4][8] = ship_i4j8;
                playerBoard[4][9] = ship_i4j9;
                playerBoard[5][0] = ship_i5j0;
                playerBoard[5][1] = ship_i5j1;
                playerBoard[5][2] = ship_i5j2;
                playerBoard[5][3] = ship_i5j3;
                playerBoard[5][4] = ship_i5j4;
                playerBoard[5][5] = ship_i5j5;
                playerBoard[5][6] = ship_i5j6;
                playerBoard[5][7] = ship_i5j7;
                playerBoard[5][8] = ship_i5j8;
                playerBoard[5][9] = ship_i5j9;
                playerBoard[6][0] = ship_i6j0;
                playerBoard[6][1] = ship_i6j1;
                playerBoard[6][2] = ship_i6j2;
                playerBoard[6][3] = ship_i6j3;
                playerBoard[6][4] = ship_i6j4;
                playerBoard[6][5] = ship_i6j5;
                playerBoard[6][6] = ship_i6j6;
                playerBoard[6][7] = ship_i6j7;
                playerBoard[6][8] = ship_i6j8;
                playerBoard[6][9] = ship_i6j9;
                playerBoard[7][0] = ship_i7j0;
                playerBoard[7][1] = ship_i7j1;
                playerBoard[7][2] = ship_i7j2;
                playerBoard[7][3] = ship_i7j3;
                playerBoard[7][4] = ship_i7j4;
                playerBoard[7][5] = ship_i7j5;
                playerBoard[7][6] = ship_i7j6;
                playerBoard[7][7] = ship_i7j7;
                playerBoard[7][8] = ship_i7j8;
                playerBoard[7][9] = ship_i7j9;
                playerBoard[8][0] = ship_i8j0;
                playerBoard[8][1] = ship_i8j1;
                playerBoard[8][2] = ship_i8j2;
                playerBoard[8][3] = ship_i8j3;
                playerBoard[8][4] = ship_i8j4;
                playerBoard[8][5] = ship_i8j5;
                playerBoard[8][6] = ship_i8j6;
                playerBoard[8][7] = ship_i8j7;
                playerBoard[8][8] = ship_i8j8;
                playerBoard[8][9] = ship_i8j9;
                playerBoard[9][0] = ship_i9j0;
                playerBoard[9][1] = ship_i9j1;
                playerBoard[9][2] = ship_i9j2;
                playerBoard[9][3] = ship_i9j3;
                playerBoard[9][4] = ship_i9j4;
                playerBoard[9][5] = ship_i9j5;
                playerBoard[9][6] = ship_i9j6;
                playerBoard[9][7] = ship_i9j7;
                playerBoard[9][8] = ship_i9j8;
                playerBoard[9][9] = ship_i9j9;
	}

	//Rescale icon while keeping aspect ratio (https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon)
	public Icon sourceIcon(String str)
	{
		URL img_url = getClass().getResource(str);

		BufferedImage buf_img = null;

		try
		{
			buf_img = ImageIO.read(img_url);
		}
		catch (IOException ex)
		{
			System.out.println(ex.toString());	
		}

		return new ImageIcon(buf_img);
	}

	//Place the ships at random locations
	public void placeRandom(JLabel label)
	{
		//Downcast to ship label
		ShipLabel ship = (ShipLabel)label;
		
		//Get two random numbers (0-9)
		int x = ThreadLocalRandom.current().nextInt(0, 9 + 1); 
		int y = ThreadLocalRandom.current().nextInt(0, 9 + 1);

		//Get a direction, NORTH (0) or WEST (1)
	       	int direction = ThreadLocalRandom.current().nextInt(0, 1 + 1);

		//Used for ship values
		int length = 0;
		Icon up_sprites[] = null;
		Icon left_sprites[] = null;

		//Grab ship values
		length = ship.getLength();
		up_sprites = ship.getUpSprites();
		left_sprites = ship.getLeftSprites();

		//If we can't place, get a new value for x and y
		while (! model.getShipBoard().canPlace(x, y, direction, length))
		{
			x = ThreadLocalRandom.current().nextInt(0, 9 + 1);
			y = ThreadLocalRandom.current().nextInt(0, 9 + 1);
		}

		//Holds the index of the ship array
		int index = 0;
		//Place ship on the tiles
		switch(direction)
		{	
			case 0:	
				//Vertical case
				for (int i = y; i < y + length ; i++)
				{
					//Place each tile and update model
					playerBoard[i][x].setIcon(up_sprites[index]);
					model.getShipBoard().getTile(i, x).setType(TileType.SHIP);
					index++;
				}
				break;
			case 1:		
				//Horizontal case
				for (int i = x; i < x + length ; i++)
				{
					//Place each tile and update model
					playerBoard[y][i].setIcon(left_sprites[index]);
					model.getShipBoard().getTile(y, i).setType(TileType.SHIP);
					index++;
				}
				break;
		}	

		//Disable ship icons	
		ship.setEnabled(false);
		ship.setVisible(false);
	}

//						INNER CLASSES
//|====================================================================================================|	
	
	//Try this way | This might be some of the weirdest code I've written but it works somehow ???	
	//Destroyer Class
	class DesLabel extends ShipLabel
	{
		public DesLabel(int length, int direction, String up_resource, String left_resource)
		{

			//Call super class constructor
			super(up_resource, left_resource);
			this.length = length;
			this.direction = direction;
			
			up_sprites = new Icon[2];
			left_sprites = new Icon[2];

			up_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/DestroyerTile1.png");	
			up_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/DestroyerTile2.png");

			left_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/DestroyerLeftTile1.png");
			left_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/DestroyerLeftTile2.png");
		}	
	}

	//Battleship Class
	class CruLabel extends ShipLabel
	{
		public CruLabel(int length, int direction, String up_resource, String left_resource)
		{

			//Call super class constructor
			super(up_resource, left_resource);
			this.length = length;
			this.direction = direction;
			
			up_sprites = new Icon[3];
			left_sprites = new Icon[3];

			up_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/CruiserTile1.png");		
			up_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/CruiserTile2.png");	
			up_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/CruiserTile3.png");	
			
			left_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/CruiserLeftTile1.png");	
			left_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/CruiserLeftTile2.png");	
			left_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/CruiserLeftTile3.png");	
		}
	}
	
	//Submarine Class
	class SubLabel extends ShipLabel
	{
		public SubLabel(int length, int direction, String up_resource, String left_resource)
		{
			super(up_resource, left_resource);
			//Call super class constructor
			this.length = length;
			this.direction = direction;
			
			up_sprites = new Icon[3];
			left_sprites = new Icon[3];

			up_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/SubmarineTile1.png");	
			up_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/SubmarineTile2.png");
			up_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/SubmarineTile3.png");

			left_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/SubmarineLeftTile1.png");
			left_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/SubmarineLeftTile2.png");
			left_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/SubmarineLeftTile3.png");
		}	
	}	
	
	//Battleship Class
	class BatLabel extends ShipLabel
	{
		public BatLabel(int length, int direction, String up_resource, String left_resource)
		{

			//Call super class constructor
			super(up_resource, left_resource);
			this.length = length;
			this.direction = direction;
			
			up_sprites = new Icon[4];
			left_sprites = new Icon[4];

			up_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/BattleshipTile1.png");	
			up_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/BattleshipTile2.png");	
			up_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/BattleshipTile3.png");	
			up_sprites[3] = sourceIcon("Graphics/Ships/ShipMod/BattleshipTile4.png");	
			
			left_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/BattleshipLeftTile1.png");	
			left_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/BattleshipLeftTile2.png");
			left_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/BattleshipLeftTile3.png");
			left_sprites[3] = sourceIcon("Graphics/Ships/ShipMod/BattleshipLeftTile4.png");
		}
	}

	//Carrier Class
	class CarLabel extends ShipLabel
	{
		public CarLabel(int length, int direction, String up_resource, String left_resource)
		{

			//Call super class constructor
			super(up_resource, left_resource);
			this.length = length;
			this.direction = direction;
			
			up_sprites = new Icon[5];
			left_sprites = new Icon[5];

			up_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/CarrierTile1.png");	
			up_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/CarrierTile2.png");	
			up_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/CarrierTile3.png");	
			up_sprites[3] = sourceIcon("Graphics/Ships/ShipMod/CarrierTile4.png");	
			up_sprites[4] = sourceIcon("Graphics/Ships/ShipMod/CarrierTile5.png");	

			left_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/CarrierLeftTile1.png");
			left_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/CarrierLeftTile2.png");
			left_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/CarrierLeftTile3.png");
			left_sprites[3] = sourceIcon("Graphics/Ships/ShipMod/CarrierLeftTile4.png");
			left_sprites[4] = sourceIcon("Graphics/Ships/ShipMod/CarrierLeftTile5.png");
		}	
	}

	class DragShip extends MouseAdapter
	{
		//Keep track of where the mouse is
		Component lastEntered;
		int direction = 0;
		int length = 0;
		Icon up_sprites[] = null;
		Icon left_sprites[] = null;
		ShipLabel ship = null;

		boolean is_ship = false;

		@Override
		public void mouseDragged(MouseEvent e)
		{
			Object obj = e.getSource();
			if (obj instanceof JLabel)
			{
				ship = (ShipLabel)obj;
				direction = ship.getDirection();
				length = ship.getLength();
				up_sprites = ship.getUpSprites();
				left_sprites = ship.getLeftSprites();
				is_ship = true;
			}
		}	
	
		public void mouseEntered(MouseEvent e)
		{
			//Set the last entered to the componet we are currently on
			lastEntered = e.getComponent();
		}
		
		@Override
		public void mouseReleased(MouseEvent e)
		{		
			if (lastEntered instanceof JButton && is_ship == true)
			{
				JButton button = (JButton)lastEntered;
				String coords[] = button.getActionCommand().split(" ");
				Point point = new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
				int x = (int)point.getX();
				int y = (int)point.getY();

				System.out.println("x and y: " + x + " " + y);
	
				if (model.getShipBoard().canPlace(x, y, direction, length))
				{
					//Disable the ability to place randomly
					setup_random.setEnabled(false);


					int index = 0;
					switch(direction)
					{	
						case 0:	
							//Place ship on the selected tiles
							for (int i = y; i < y + length ; i++)
							{
								playerBoard[i][x].setIcon(up_sprites[index]);
								model.getShipBoard().getTile(i, x).setType(TileType.SHIP);
								index++;
							}
							break;
						case 1:		
							for (int i = x; i < x + length ; i++)
							{
								playerBoard[y][i].setIcon(left_sprites[index]);
								model.getShipBoard().getTile(y, i).setType(TileType.SHIP);
								index++;
							}
							break;
					}	
		
					//Disable ship icons	
					ship.setEnabled(false);
					ship.setVisible(false);
				}	
			}
			
			//If the user lets go of the ship, stop the drag action
			is_ship = false;
		}
	}

	//Action listener for the randomize button
	class RandomSetupListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//Get button so we can disable it
			Object obj = e.getSource();
			JButton button = null;

			if (obj instanceof JButton)
				button = (JButton)obj;
			
			//Call place random on each ship
			placeRandom(des);
			placeRandom(sub);
			placeRandom(cru);
			placeRandom(bat);
			placeRandom(car);

			//Disable the button
			button.setEnabled(false);
		}
	}
}
