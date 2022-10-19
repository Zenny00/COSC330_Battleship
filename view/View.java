//Name(s): Joshua Comfort & Justin Conklin
//Date: 10/5/2022
//Description: Implementation of the view class for the Battleship game GUI
//Water sprite based on: https://www.deviantart.com/oni1ink/art/Tutorial-How-to-draw-Water-645199166

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

public class View extends JFrame
{
	//					PRIVATE DATA MEMEBERS
	//|====================================================================================================|
	
	//This line is commented for now until view is placed in the same directory as model
	//private dataModel Model;
	
	//Constants for the number of ships and the size of each board
	private final int BOARD_SIZE = 10;
	private final int NUM_SHIPS = 5;
	private static double rot = 0.0;	

	//Holds the input and output text
	private JTextField userInput; 
	private JTextArea consoleOut;

	//Array of JButtons for the player's boards
	private JButton playerBoard[][] = new JButton[BOARD_SIZE][BOARD_SIZE];
	private JButton enemyBoard[][] = new JButton[BOARD_SIZE][BOARD_SIZE];

	//Array of image icons to hold ships
	private JPanel ships[] = new JPanel[NUM_SHIPS];

	//Setup panels and arrays
	private JPanel shipButtonPanel = new JPanel();
	private JPanel shipContainerPanel = new JPanel();
	private JPanel targetButtonPanel = new JPanel();
	private JPanel targetContainerPanel = new JPanel();

	private JPanel shipBox = new JPanel();

	//Ships
	private BufferedImage sub_image = new BufferedImage(30, 30, BufferedImage.TYPE_INT_RGB);//"Graphics/Ships/Submarine.png");
	private RotatedIcon sub_icon = new RotatedIcon(new ImageIcon("Graphics/Ships/Submarine.png"), 0);
	private ImageIcon sub1_icon = new ImageIcon("Graphics/Ships/ShipMod/SubmarineTile1.png");
	private ImageIcon sub2_icon = new ImageIcon("Graphics/Ships/ShipMod/SubmarineTile2.png");
	private ImageIcon sub3_icon = new ImageIcon("Graphics/Ships/ShipMod/SubmarineTile3.png");

	private JLabel sub;
	private JLabel sub1;
	private JLabel sub2;
	private JLabel sub3;

	private JPanel submarine; 

	//https://www.reddit.com/r/learnprogramming/comments/7dm4z2/java_how_to_rotate_an_imageicon_in_a_jlabel_with/
	private JLabel des1 = new JLabel(new ImageIcon("Graphics/Ships/ShipMod/DestroyerTile1.png"));
	private JLabel des2 = new JLabel(new ImageIcon("Graphics/Ships/ShipMod/DestroyerTile2.png"));
	private JPanel destroyer = new JPanel();
	
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

	//Ship tiles
	private JButton ship_i0j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i0j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i0j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i0j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i0j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i0j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i0j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i0j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i0j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i0j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i1j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i1j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i1j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i1j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i1j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i1j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i1j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i1j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i1j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i1j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i2j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i2j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i2j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i2j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i2j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i2j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i2j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i2j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i2j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i2j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i3j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i3j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i3j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i3j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i3j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i3j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i3j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i3j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i3j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i3j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i4j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i4j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i4j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i4j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i4j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i4j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i4j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i4j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i4j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i4j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i5j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i5j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i5j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i5j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i5j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i5j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i5j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i5j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i5j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i5j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i6j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i6j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i6j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i6j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i6j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i6j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i6j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i6j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i6j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i6j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i7j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i7j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i7j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i7j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i7j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i7j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i7j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i7j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i7j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i7j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i8j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i8j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i8j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i8j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i8j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i8j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i8j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i8j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i8j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i8j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i9j0= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i9j1= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i9j2= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i9j3= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i9j4= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i9j5= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i9j6= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i9j7= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i9j8= new JButton(new ImageIcon("Graphics/Water/Water.png"));
	private JButton ship_i9j9= new JButton(new ImageIcon("Graphics/Water/Water.png"));

	private int img_width = (int)sub_icon.getIconHeight();
	private int img_height = (int)sub_icon.getIconWidth();

        private Point image_corner = new Point();
        private Point previousPoint;

	private Model model;
	private int direction = 0;
	private int length = 3;

	//|====================================================================================================|
	


	//						FUNCTIONS
	//|====================================================================================================|


	//Constructor 
	public View(Model model, Role connect_panel)
	{
		//Set the model
		this.model = model;

		//Setup for Jpanels
		GridLayout contentLayout = new GridLayout(2, 2);
		contentLayout.setVgap(10);
		contentLayout.setHgap(10);
		getContentPane().setLayout(contentLayout);
		shipButtonPanel.setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));
		targetButtonPanel.setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));	
		shipButtonPanel.setPreferredSize(new Dimension(300, 300));
		shipContainerPanel.add(shipButtonPanel);
		shipContainerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		targetButtonPanel.setPreferredSize(new Dimension(300, 300));
		targetContainerPanel.add(targetButtonPanel);
		targetContainerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		//Setup boards
		assignEnemyBoard();
		assignPlayerBoard();
	
		//addTileListener(new TileListener()); 

		//				--- CONFIGURE SHIPS ---
		// |------------------------------------------------------------------------------------|
		// | 1. Destroyer									|
		// | 2. Submarine									|
		// | 3. Cruiser										|
		// | 4. Battleship									|
		// | 5. Carrier										|
		// |------------------------------------------------------------------------------------|

		//Configure destroyer
		destroyer.add(des1);
		destroyer.add(des2);
		destroyer.setLayout(new BoxLayout(destroyer, BoxLayout.Y_AXIS));

		//Assign destroyer to the ship array
		ships[0] = destroyer;
		//Add destroyer to the content pane
		shipBox.add(destroyer);

		sub = new JLabel(sub_icon);	

		sub.addMouseListener(new RotationHandler());	

		//Drag and drop
		ShipDrag drag_ship = new ShipDrag();
		//Initialize 2D array for boards
		initJButtons(drag_ship);
		sub.addMouseListener(drag_ship);
		sub.addMouseMotionListener(drag_ship);

		//Setup TransferHandlers to move icons between the labels
		//sub.setTransferHandler(new TransferHandler("icon"));

		//https://stackoverflow.com/questions/22698435/listen-for-mouse-released-event-on-component-on-which-the-mouse-was-not-pressed

		//submarine = new JPanel();

		//Configure submarine
		//submarine.add(sub);
		//submarine.add(sub2);
		//submarine.add(sub3);
		//submarine.setLayout(new BoxLayout(submarine, BoxLayout.Y_AXIS));

		//Assign submarine to the ship array
		ships[1] = submarine;
		//Add submarine to the content pane
		shipBox.add(sub);
		image_corner = new Point(sub.getX(), sub.getY());

		//Setup shipbox for holding ships
		shipBox.setLayout(new GridLayout(1, 5));

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

	public void initJButtons(ShipDrag drag)
	{
		int x = 0, y = 0;
		for (JButton[] row: playerBoard)
		{
			for (JButton button: row)
			{
				//Create new button with water icon
				button = new JButton(new ImageIcon("Graphics/Water/Water.png"));
				
				//Set text to coordinates and scale
				button.setActionCommand(String.valueOf(x) + " " + String.valueOf(y));
				button.setPreferredSize(new Dimension(30, 30));
				button.setTransferHandler(new TransferHandler("icon"));
				button.addMouseListener(drag);
				//button.setEnabled(false);
				//Add JButton to JPanel
				shipButtonPanel.add(button);
				x++;
			}	
			x = 0;
			y++;
		}

		x = 0;
		for (JButton[] row: enemyBoard)
		{	
			for (JButton button: row)
			{
				button.setActionCommand(String.valueOf(x) + " " + String.valueOf(y));
				button.setPreferredSize(new Dimension(30, 30));
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
		for (JButton[] row: enemyBoard)	
			for (JButton button: row)
				button.addActionListener(fire);
	}

	public void addClickListener(MouseListener listener)
	{
		submarine.addMouseListener(listener);
	}

	public void addDragListener(MouseMotionListener listener)
	{
		submarine.addMouseMotionListener(listener);
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
	public JButton getTargetButton(int x, int y)
	{
		//What board are we getting a tile from?
		return enemyBoard[x][y];	
	}

	//Return JButton at specified location within the grid
	public JButton getShipButton(int x, int y)
	{
		//What board are we getting a tile from?
		return playerBoard[x][y];	
	}

	//Update a button at a specified location in the grid
	public void updateButton(int x, int y)
	{
		//TODO
	}

	public JPanel getTargetPanel() {return targetButtonPanel;}
	public JPanel getShipPanel() {return shipButtonPanel;}

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

//						INNER CLASSES
//|====================================================================================================|	
//Define the transfer handler
	/*
	class MouseDragListener extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent e)
		{
			Object obj = e.getSource();
			if (obj instanceof JButton)
			\{	
				JButton button = (JButton)obj;
				System.out.println(button.getActionCommand());
			}
			System.out.println("HI");
			
		}
	}
	*/

	//Try this way
		
	class ShipDrag extends MouseAdapter
	{
		//Keep track of where the mouse is
		//Object firstEntered;
		//Object lastEntered;
		Component lastEntered;

		@Override
		public void mouseDragged(MouseEvent e)
		{
			/*
			Object obj = e.getSource();
			if (obj instanceof JButton)
			{	
				JButton button = (JButton)obj;
				System.out.println(button.getActionCommand());
			}
			*/
			System.out.println("HI");
			
			//Set the first component to the object was pressed on
			//firstEntered = e.getSource();
			//System.out.println(firstEntered.getClass());	
		}	

		public void mouseMoved(MouseEvent e)
		{
			//TODO
		}
		
		public void mouseClicked(MouseEvent arg0) {

		}

		public void mouseExited(MouseEvent arg0) {

		}

		public void mouseEntered(MouseEvent e)
	       	{
			//Set the last entered to the componet we are currently on
			lastEntered = e.getComponent();
		}

		public void mousePressed(MouseEvent e) 
		{
			//TODO			
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("Welcome to Java Programming!");
			//Component obj = getComponentAt(e.getSource());
			
			//JComponent comp = (JComponent) e.getSource();
         		//Object obj = e.getSource();
			if (lastEntered instanceof JButton)
			{
				JButton button = (JButton)lastEntered;
				String coords[] = button.getActionCommand().split(" ");
				Point point = new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
				int x = (int)point.getX();
				int y = (int)point.getY();
                		System.out.println(x + " " + y);
				playerBoard[x][y].setIcon(sub1_icon);
				
				if (model.getShipBoard().canPlace(x, y, direction, length))
				{
					System.out.println("Can place!");
					switch(direction)
					{
						case 0:	
							//Place ship on the selected tiles
							for (int i = y; i <= y + length ; i++)
							{
								playerBoard[x][i].setIcon(null);
								playerBoard[x][i].setIcon(sub1_icon);
							}
							break;
						case 1:		
							for (int i = x; i <= x + length ; i++)
							{
								playerBoard[i][y].setIcon(null);
								playerBoard[i][y].setIcon(sub1_icon);
							}
							break;
						case 2:	
							for (int i = y; i >= y - length; i--)
							{
								playerBoard[i][y].setIcon(null);
								playerBoard[i][y].setIcon(sub1_icon);
							}
							break;
						case 3:
							for (int i = x; i >= x - length; i--)
							{
								playerBoard[x][i].setIcon(null);
								playerBoard[x][i].setIcon(sub1_icon);
							}
							break;
					}
				}
				else
					System.out.println("Cannot place!");	
			}
		}
	}
	

	class RotationHandler extends MouseAdapter 
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			if (e.getModifiers() == MouseEvent.BUTTON3_MASK) 
			{
				Object obj = e.getSource();
				if (obj instanceof JLabel)
				{
					direction++;
					if (direction > 3)
						direction = 0;

					JLabel ship = (JLabel)obj;
					RotatedIcon icon = new RotatedIcon(ship.getIcon());
					icon.setDegrees(icon.getDegrees() - 90);
					//direction = Math.abs((int)icon.getDegrees());
					System.out.println(direction);
					ship.setIcon(icon);
					ship.revalidate();
					ship.repaint();
				}
			}
		}				
	}
}
