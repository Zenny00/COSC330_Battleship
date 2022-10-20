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
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

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
	
	private int img_width = (int)sub_icon.getIconHeight();
	private int img_height = (int)sub_icon.getIconWidth();

        private Point image_corner = new Point();
        private Point previousPoint;

	private Model model;
	private int direction = 0;
	private int length = 3;
	private String sub_up_resource = "Graphics/Ships/Submarine.png";
	private String sub_left_resource = "Graphics/Ships/SubmarineLeft.png";
       	private Icon sub_up_icon = null;
	private Icon sub_left_icon = null;	
	private Icon submarine_up_sprites[] = null;
	private Icon submarine_left_sprites[] = null;

	//|====================================================================================================|
	


	//						FUNCTIONS
	//|====================================================================================================|


	//Constructor 
	public View(Model model, Role connect_panel)
	{
		URL sub_up_url = getClass().getResource(sub_up_resource);
		URL sub_left_url = getClass().getResource(sub_left_resource);
		
		BufferedImage sub_left_img = null;
		BufferedImage sub_up_img = null;

		try
		{
			sub_up_img = ImageIO.read(sub_up_url);
			sub_left_img = ImageIO.read(sub_left_url);
		}
		catch (IOException ex)
		{
			System.out.println(ex.toString());	
		}

		sub_up_icon = scaleImage(new ImageIcon(sub_up_img), 30, 90);
		sub_left_icon = scaleImage(new ImageIcon(sub_left_img), 90, 30);

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

		sub = new JLabel();	
		sub.setIcon(sub_up_icon);

		sub.addMouseListener(new RotationHandler());	

		//Drag and drop
		ShipDrag drag_ship = new ShipDrag();
		//Initialize 2D array for boards
		
		//Try to initialize JButtons
		try
		{
			initJButtons(drag_ship);
		}
		catch (IOException ex)
		{
			System.out.println(ex.toString());
		}

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

	public void initJButtons(ShipDrag drag) throws IOException 
	{
		String water_resource = "Graphics/Water/Water.png";
		URL water_url = getClass().getResource(water_resource);
		BufferedImage water_img = null;
		
		try
		{
			water_img = ImageIO.read(water_url);
		}	
		catch (IOException ex)
		{
			System.out.println(ex.toString());
		}

		Icon water_icon = new ImageIcon(water_img);
		
		int x = 0, y = 0;
		for (JButton[] row: playerBoard)
		{
			for (JButton button: row)
			{
				//Create new button with water icon
				//button = new JButton(new ImageIcon("Graphics/Water/Water.png"));	
				//Set text to coordinates and scale
				button.setActionCommand(String.valueOf(x) + " " + String.valueOf(y));
				button.setPreferredSize(new Dimension(30, 30));
				button.setTransferHandler(new TransferHandler("icon"));
				button.addMouseListener(drag);
				
				//Set up the image icon
				button.setIcon(water_icon);
				
				//button.setEnabled(false);
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
		return targetBoard[x][y];	
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
		public void mouseReleased(MouseEvent e)
		{
		
			submarine_up_sprites = new Icon[3];
			submarine_left_sprites = new Icon[3];

			submarine_up_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/SubmarineTile1.png");	
			submarine_up_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/SubmarineTile2.png");
			submarine_up_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/SubmarineTile3.png");

			submarine_left_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/SubmarineLeftTile1.png");
			submarine_left_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/SubmarineLeftTile2.png");
			submarine_left_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/SubmarineLeftTile3.png");

			System.out.println("Welcome to Java Programming!");
			//Component obj = getComponentAt(e.getSource());
		
			String ship_resource = "Graphics/Ships/ShipMod/SubmarineTile1.png";
			URL ship_url = getClass().getResource(ship_resource);
			BufferedImage ship_img = null;
		       	
			try
			{
				ship_img = ImageIO.read(ship_url);
			}
			catch (IOException ex)
			{
				System.out.println(ex.toString());	
			}

			Icon ship_icon = new ImageIcon(ship_img);

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
				//playerBoard[x][y].setIcon(sub1_icon);
				
				if (model.getShipBoard().canPlace(x, y, direction, length))
				{
					System.out.println("Can place!");
					
					int index = 0;
					switch(direction)
					{	
						case 0:	
							//Place ship on the selected tiles
							for (int i = y; i < y + length ; i++)
							{
								playerBoard[i][x].setIcon(submarine_up_sprites[index]);
								model.getShipBoard().getTile(i, x).setType(TileType.SHIP);
								index++;
							}
							break;
						case 1:		
							for (int i = x; i < x + length ; i++)
							{
								playerBoard[y][i].setIcon(submarine_left_sprites[index]);

								model.getShipBoard().getTile(y, i).setType(TileType.SHIP);
								index++;
							}
							break;
					}

					sub.setIcon(null);
					sub.revalidate();
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
					if (direction > 1)
						direction = 0;

					JLabel ship = (JLabel)obj;
				
					if (direction == 0)
						ship.setIcon(sub_up_icon);	
					else
						ship.setIcon(sub_left_icon);

					System.out.println(direction);
					ship.revalidate();
					ship.repaint();
				}
			}
		}				
	}
}
