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
import java.io.File;
import java.io.*;
import javax.sound.sampled.*;
import java.util.concurrent.TimeUnit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import javax.sound.sampled.LineEvent;
import java.applet.*;

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

	//Setup panels to hold buttons and ships
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
		
	//Init Ship JButton | MUST BE DONE BEFORE CONSTRUCTOR!"
	private JButton ship_i0j0 = new JButton();
	private JButton ship_i0j1 = new JButton();
	private JButton ship_i0j2 = new JButton();
	private JButton ship_i0j3 = new JButton();
	private JButton ship_i0j4 = new JButton();
	private JButton ship_i0j5 = new JButton();
	private JButton ship_i0j6 = new JButton();
	private JButton ship_i0j7 = new JButton();
	private JButton ship_i0j8 = new JButton();
	private JButton ship_i0j9 = new JButton();
	private JButton ship_i1j0 = new JButton();
	private JButton ship_i1j1 = new JButton();
	private JButton ship_i1j2 = new JButton();
	private JButton ship_i1j3 = new JButton();
	private JButton ship_i1j4 = new JButton();
	private JButton ship_i1j5 = new JButton();
	private JButton ship_i1j6 = new JButton();
	private JButton ship_i1j7 = new JButton();
	private JButton ship_i1j8 = new JButton();
	private JButton ship_i1j9 = new JButton();
	private JButton ship_i2j0 = new JButton();
	private JButton ship_i2j1 = new JButton();
	private JButton ship_i2j2 = new JButton();
	private JButton ship_i2j3 = new JButton();
	private JButton ship_i2j4 = new JButton();
	private JButton ship_i2j5 = new JButton();
	private JButton ship_i2j6 = new JButton();
	private JButton ship_i2j7 = new JButton();
	private JButton ship_i2j8 = new JButton();
	private JButton ship_i2j9 = new JButton();
	private JButton ship_i3j0 = new JButton();
	private JButton ship_i3j1 = new JButton();
	private JButton ship_i3j2 = new JButton();
	private JButton ship_i3j3 = new JButton();
	private JButton ship_i3j4 = new JButton();
	private JButton ship_i3j5 = new JButton();
	private JButton ship_i3j6 = new JButton();
	private JButton ship_i3j7 = new JButton();
	private JButton ship_i3j8 = new JButton();
	private JButton ship_i3j9 = new JButton();
	private JButton ship_i4j0 = new JButton();
	private JButton ship_i4j1 = new JButton();
	private JButton ship_i4j2 = new JButton();
	private JButton ship_i4j3 = new JButton();
	private JButton ship_i4j4 = new JButton();
	private JButton ship_i4j5 = new JButton();
	private JButton ship_i4j6 = new JButton();
	private JButton ship_i4j7 = new JButton();
	private JButton ship_i4j8 = new JButton();
	private JButton ship_i4j9 = new JButton();
	private JButton ship_i5j0 = new JButton();
	private JButton ship_i5j1 = new JButton();
	private JButton ship_i5j2 = new JButton();
	private JButton ship_i5j3 = new JButton();
	private JButton ship_i5j4 = new JButton();
	private JButton ship_i5j5 = new JButton();
	private JButton ship_i5j6 = new JButton();
	private JButton ship_i5j7 = new JButton();
	private JButton ship_i5j8 = new JButton();
	private JButton ship_i5j9 = new JButton();
	private JButton ship_i6j0 = new JButton();
	private JButton ship_i6j1 = new JButton();
	private JButton ship_i6j2 = new JButton();
	private JButton ship_i6j3 = new JButton();
	private JButton ship_i6j4 = new JButton();
	private JButton ship_i6j5 = new JButton();
	private JButton ship_i6j6 = new JButton();
	private JButton ship_i6j7 = new JButton();
	private JButton ship_i6j8 = new JButton();
	private JButton ship_i6j9 = new JButton();
	private JButton ship_i7j0 = new JButton();
	private JButton ship_i7j1 = new JButton();
	private JButton ship_i7j2 = new JButton();
	private JButton ship_i7j3 = new JButton();
	private JButton ship_i7j4 = new JButton();
	private JButton ship_i7j5 = new JButton();
	private JButton ship_i7j6 = new JButton();
	private JButton ship_i7j7 = new JButton();
	private JButton ship_i7j8 = new JButton();
	private JButton ship_i7j9 = new JButton();
	private JButton ship_i8j0 = new JButton();
	private JButton ship_i8j1 = new JButton();
	private JButton ship_i8j2 = new JButton();
	private JButton ship_i8j3 = new JButton();
	private JButton ship_i8j4 = new JButton();
	private JButton ship_i8j5 = new JButton();
	private JButton ship_i8j6 = new JButton();
	private JButton ship_i8j7 = new JButton();
	private JButton ship_i8j8 = new JButton();
	private JButton ship_i8j9 = new JButton();
	private JButton ship_i9j0 = new JButton();
	private JButton ship_i9j1 = new JButton();
	private JButton ship_i9j2 = new JButton();
	private JButton ship_i9j3 = new JButton();
	private JButton ship_i9j4 = new JButton();
	private JButton ship_i9j5 = new JButton();
	private JButton ship_i9j6 = new JButton();
	private JButton ship_i9j7 = new JButton();
	private JButton ship_i9j8 = new JButton();
	private JButton ship_i9j9 = new JButton();

	//Init Target JButton | MUST BE DONE BEFORE CONSTRUCTOR!"
	private JButton target_i0j0 = new JButton();
	private JButton target_i0j1 = new JButton();
	private JButton target_i0j2 = new JButton();
	private JButton target_i0j3 = new JButton();
	private JButton target_i0j4 = new JButton();
	private JButton target_i0j5 = new JButton();
	private JButton target_i0j6 = new JButton();
	private JButton target_i0j7 = new JButton();
	private JButton target_i0j8 = new JButton();
	private JButton target_i0j9 = new JButton();
	private JButton target_i1j0 = new JButton();
	private JButton target_i1j1 = new JButton();
	private JButton target_i1j2 = new JButton();
	private JButton target_i1j3 = new JButton();
	private JButton target_i1j4 = new JButton();
	private JButton target_i1j5 = new JButton();
	private JButton target_i1j6 = new JButton();
	private JButton target_i1j7 = new JButton();
	private JButton target_i1j8 = new JButton();
	private JButton target_i1j9 = new JButton();
	private JButton target_i2j0 = new JButton();
	private JButton target_i2j1 = new JButton();
	private JButton target_i2j2 = new JButton();
	private JButton target_i2j3 = new JButton();
	private JButton target_i2j4 = new JButton();
	private JButton target_i2j5 = new JButton();
	private JButton target_i2j6 = new JButton();
	private JButton target_i2j7 = new JButton();
	private JButton target_i2j8 = new JButton();
	private JButton target_i2j9 = new JButton();
	private JButton target_i3j0 = new JButton();
	private JButton target_i3j1 = new JButton();
	private JButton target_i3j2 = new JButton();
	private JButton target_i3j3 = new JButton();
	private JButton target_i3j4 = new JButton();
	private JButton target_i3j5 = new JButton();
	private JButton target_i3j6 = new JButton();
	private JButton target_i3j7 = new JButton();
	private JButton target_i3j8 = new JButton();
	private JButton target_i3j9 = new JButton();
	private JButton target_i4j0 = new JButton();
	private JButton target_i4j1 = new JButton();
	private JButton target_i4j2 = new JButton();
	private JButton target_i4j3 = new JButton();
	private JButton target_i4j4 = new JButton();
	private JButton target_i4j5 = new JButton();
	private JButton target_i4j6 = new JButton();
	private JButton target_i4j7 = new JButton();
	private JButton target_i4j8 = new JButton();
	private JButton target_i4j9 = new JButton();
	private JButton target_i5j0 = new JButton();
	private JButton target_i5j1 = new JButton();
	private JButton target_i5j2 = new JButton();
	private JButton target_i5j3 = new JButton();
	private JButton target_i5j4 = new JButton();
	private JButton target_i5j5 = new JButton();
	private JButton target_i5j6 = new JButton();
	private JButton target_i5j7 = new JButton();
	private JButton target_i5j8 = new JButton();
	private JButton target_i5j9 = new JButton();
	private JButton target_i6j0 = new JButton();
	private JButton target_i6j1 = new JButton();
	private JButton target_i6j2 = new JButton();
	private JButton target_i6j3 = new JButton();
	private JButton target_i6j4 = new JButton();
	private JButton target_i6j5 = new JButton();
	private JButton target_i6j6 = new JButton();
	private JButton target_i6j7 = new JButton();
	private JButton target_i6j8 = new JButton();
	private JButton target_i6j9 = new JButton();
	private JButton target_i7j0 = new JButton();
	private JButton target_i7j1 = new JButton();
	private JButton target_i7j2 = new JButton();
	private JButton target_i7j3 = new JButton();
	private JButton target_i7j4 = new JButton();
	private JButton target_i7j5 = new JButton();
	private JButton target_i7j6 = new JButton();
	private JButton target_i7j7 = new JButton();
	private JButton target_i7j8 = new JButton();
	private JButton target_i7j9 = new JButton();
	private JButton target_i8j0 = new JButton();
	private JButton target_i8j1 = new JButton();
	private JButton target_i8j2 = new JButton();
	private JButton target_i8j3 = new JButton();
	private JButton target_i8j4 = new JButton();
	private JButton target_i8j5 = new JButton();
	private JButton target_i8j6 = new JButton();
	private JButton target_i8j7 = new JButton();
	private JButton target_i8j8 = new JButton();
	private JButton target_i8j9 = new JButton();
	private JButton target_i9j0 = new JButton();
	private JButton target_i9j1 = new JButton();
	private JButton target_i9j2 = new JButton();
	private JButton target_i9j3 = new JButton();
	private JButton target_i9j4 = new JButton();
	private JButton target_i9j5 = new JButton();
	private JButton target_i9j6 = new JButton();
	private JButton target_i9j7 = new JButton();
	private JButton target_i9j8 = new JButton();
	private JButton target_i9j9 = new JButton();	

	//Setup new JButton to allow the user to randomize their ships
	private JButton setup_random = new JButton();	

	//JButton that will be pressed when player is done setting up their ships
	private JButton setup_done = new JButton();	

	//JButton that will be pressed if player wants to restart ship setup
	private JButton reset_button = new JButton();	

	//Allow the user to restart the game
	private JButton restart_button = new JButton();

	//Allow the user to exit the game
	private JButton exit_button = new JButton();

	//Int to keep track of the number of ships left to place
	private int ships_placed;
	
	//Holds the current status of the game
	private JPanel status;

	//Holds the ending icon and buttons
	private JPanel button_panel;
	private JLabel game_end;

	//Used to hold the URL's of sounds
	private URL water_sound_url = null;
	private URL incorrect_sound_url = null;
	private URL hit_sound_url = null;
	private URL miss_sound_url = null;
	private URL enemy_hit_sound_url = null;
	private URL enemy_miss_sound_url = null;
	private URL music_sound_url = null;
	private URL ship_sunk_sound_url = null;
	private URL win_sound_url = null;
	private URL lose_sound_url = null;

	//Audio clips for sounds and music
	private AudioClip background_music = null;
	private AudioClip sound_clip = null;

	//|=====================================================================================================|
	//|													|
	//|						FUNCTIONS						|
	//|													|
	//|=====================================================================================================|
	
	//Constructor 
	public View(Model model, JPanel status)
	{
		this.status = status;
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
	
		//The player has not yet placed any ships, set ships_placed to none
		ships_placed = 0;
		
		//Ship label objs to hold the ship icons and actions
		des = new DesLabel(2, 0, "Graphics/Ships/Destroyer.png", "Graphics/Ships/DestroyerLeft.png", "Graphics/Ships/DestroyerError.png", "Graphics/Ships/DestroyerLeftError.png");
		sub = new SubLabel(3, 0, "Graphics/Ships/Submarine.png", "Graphics/Ships/SubmarineLeft.png", "Graphics/Ships/SubmarineError.png", "Graphics/Ships/SubmarineLeftError.png");	
		cru = new CruLabel(3, 0, "Graphics/Ships/Cruiser.png", "Graphics/Ships/CruiserLeft.png", "Graphics/Ships/CruiserError.png", "Graphics/Ships/CruiserLeftError.png");	
		bat = new BatLabel(4, 0, "Graphics/Ships/Battleship.png", "Graphics/Ships/BattleshipLeft.png", "Graphics/Ships/BattleshipError.png", "Graphics/Ships/BattleshipLeftError.png");
		car = new CarLabel(5, 0, "Graphics/Ships/Carrier.png", "Graphics/Ships/CarrierLeft.png", "Graphics/Ships/CarrierError.png", "Graphics/Ships/CarrierLeftError.png");

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
		setup_random.setText("RANDOMIZE");
		setup_random.addActionListener(new RandomSetupListener());

		//Setup done button
		setup_done.setPreferredSize(new Dimension(60, 30));
		setup_done.setText("READY");
		setup_done.setEnabled(false);
		setup_done.setVisible(false);

		//Setup the reset button
		reset_button.setPreferredSize(new Dimension(60, 30));
		reset_button.setText("RESET");

		//Setup the restart button
		restart_button.setPreferredSize(new Dimension(120, 60));
		restart_button.setText("RESET");
		restart_button.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		restart_button.setBackground(new Color(51, 153, 255));
		restart_button.setOpaque(true);	

		//Setup the exit button
		exit_button.setPreferredSize(new Dimension(120, 60));
		exit_button.setText("EXIT");
		exit_button.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		exit_button.setBackground(new Color(51, 153, 255));
		exit_button.setOpaque(true);

		//Add ship buttons to the content pane
		shipBox.add(setup_random);
		shipBox.add(new JLabel());
		shipBox.add(reset_button);
		shipBox.add(new JLabel());
		shipBox.add(setup_done);
		
		//Add ships to the content pane
		shipBox.add(des);
		shipBox.add(sub);
		shipBox.add(cru);
		shipBox.add(bat);
		shipBox.add(car);
	
		//Setup colors
		shipBox.setBackground(new Color(0, 0, 80));
		this.getContentPane().setBackground(new Color(141, 153, 174));
		targetContainerPanel.setBackground(new Color(141, 153, 174));
		shipContainerPanel.setBackground(new Color(141, 153, 174));

		//Add white border to ship panel
		shipBox.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		
		//Add thinner white borders to the two boards
		shipButtonPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		targetButtonPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		
		//Give buttons gold border and set background to light blue
		setup_random.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		setup_random.setBackground(new Color(51, 153, 255));
		setup_random.setOpaque(true);
		setup_done.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		setup_done.setBackground(new Color(51, 153, 255));
		setup_done.setOpaque(true);
		reset_button.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		reset_button.setBackground(new Color(51, 153, 255));
		reset_button.setOpaque(true);

		//Setup shipbox for holding ships
		shipBox.setLayout(new GridLayout(2, 5));

		//Setup sound
		try
		{
			water_sound_url = this.getClass().getClassLoader().getResource("Graphics/Sounds/WaterSplash.wav");
 			incorrect_sound_url = this.getClass().getClassLoader().getResource("Graphics/Sounds/IncorrectPlacement.wav");
 			hit_sound_url = this.getClass().getClassLoader().getResource("Graphics/Sounds/HitSound.wav");

 			miss_sound_url = this.getClass().getClassLoader().getResource("Graphics/Sounds/MissSound.wav");
			music_sound_url = this.getClass().getClassLoader().getResource("Graphics/Sounds/MusicTrack.wav");

			enemy_hit_sound_url = this.getClass().getClassLoader().getResource("Graphics/Sounds/EnemyHit.wav");
			enemy_miss_sound_url = this.getClass().getClassLoader().getResource("Graphics/Sounds/EnemyMiss.wav");
			ship_sunk_sound_url = this.getClass().getClassLoader().getResource("Graphics/Sounds/ShipSink.wav");
		
			win_sound_url = this.getClass().getClassLoader().getResource("Graphics/Sounds/WinSound.wav");
			lose_sound_url = this.getClass().getClassLoader().getResource("Graphics/Sounds/LoseSound.wav");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		//Configure frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 800);
		this.setTitle("BATTLESHIP");
		this.setLocationRelativeTo(null);
	
		//Add panels to content pane	
		this.getContentPane().add(targetContainerPanel);
		this.getContentPane().add(status);
		this.getContentPane().add(shipContainerPanel);
		this.getContentPane().add(shipBox);
			
		//Pack and set visibility
		pack();
		setVisible(true);
	}

	//Flash the border of the board and play a sound
	public void targetBoardError()
	{
		targetButtonPanel.setBorder(new LineBorder(new Color(255, 0, 0), 2));
		
		long delay_time = 250; //Stored in milliseconds
		
		playIncorrect(); //Play incorrect sound

		//When the timer ends, reset the icon
		TimerTask resetBorder = new TimerTask()
		{
			public void run()
			{
				targetButtonPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			}
		};

		Timer reset_timer = new Timer();

		reset_timer.schedule(resetBorder, delay_time); //Start the timer  		
	}
	
	//Add reset listener to the reset button
	public void addResetListener(ActionListener action)
	{
		reset_button.addActionListener(action);
	}	

	//Add done listener to the finish setup button
	public void addDoneListener(ActionListener action)
	{
		setup_done.addActionListener(action);
	}	

	//Initialize the two button panels
	public void initJButtons(DragShip drag_des, DragShip drag_sub, DragShip drag_cru, DragShip drag_bat, DragShip drag_car) throws IOException 
	{
		//Load water icon
		Icon water_icon = sourceIcon("Graphics/Water/Water.png");
	
		//Varibles to adding index to buttons	
		for (int i = 0; i < BOARD_SIZE; i++)
		       for (int j = 0; j < BOARD_SIZE; j++)	
		       {
				//Set command to coordinates and scale
				playerBoard[i][j].setActionCommand(String.valueOf(j) + " " + String.valueOf(i));
				playerBoard[i][j].setPreferredSize(new Dimension(30, 30));
				
				//Add proper action listeners to the tiles
				playerBoard[i][j].addMouseListener(drag_des);
				playerBoard[i][j].addMouseListener(drag_sub);
				playerBoard[i][j].addMouseListener(drag_cru);
				playerBoard[i][j].addMouseListener(drag_bat);
				playerBoard[i][j].addMouseListener(drag_car);
				
				//Set up the image icon
				playerBoard[i][j].setIcon(water_icon);
				
				//Add JButton to JPanel
				shipButtonPanel.add(playerBoard[i][j]);
			}	

		//Setup the target board
		for (int i = 0; i < BOARD_SIZE; i++)
		       for (int j = 0; j < BOARD_SIZE; j++)	
		       {
				targetBoard[i][j].setActionCommand(String.valueOf(j) + " " + String.valueOf(i));
				targetBoard[i][j].setPreferredSize(new Dimension(30, 30));
				
				//Set up the image icon
				targetBoard[i][j].setIcon(water_icon);
				targetButtonPanel.add(targetBoard[i][j]);
			}
	}

	//Remove all ships from the player's board
	public void resetOceanBoard()
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() 
			{
				//Set the ocean icons back to default
				for (int i = 0; i < BOARD_SIZE; i++)
				       for (int j = 0; j < BOARD_SIZE; j++)	
						playerBoard[i][j].setIcon(sourceIcon("Graphics/Water/Water.png"));
	
			}
		});
	}

	//Remove all shots from the target board
	public void resetTargetBoard()
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() 
			{
				//Set the target board icons back to the default
				for (int i = 0; i < BOARD_SIZE; i++)
				       for (int j = 0; j < BOARD_SIZE; j++)	
						targetBoard[i][j].setIcon(sourceIcon("Graphics/Water/Water.png"));
			}
		});
	}

	//Enable and set all ships to visible
	public void resetShips()
	{
		ships_placed = 0;

		//Enable ship icons	
		car.setEnabled(true);
		car.setVisible(true);
		bat.setEnabled(true);
		bat.setVisible(true);
		cru.setEnabled(true);
		cru.setVisible(true);
		sub.setEnabled(true);
		sub.setVisible(true);
		des.setEnabled(true);
		des.setVisible(true);
	}

	//Reset buttons to initial state
	public void resetButtons()
	{
		setup_random.setEnabled(true);
		setup_random.setVisible(true);
		reset_button.setEnabled(true);
		reset_button.setVisible(true);
		setup_done.setEnabled(false);
		setup_done.setVisible(false);
	}

	//Hide and disable the reset button
	public void hideReset()
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() 
			{
				reset_button.setEnabled(false);
				reset_button.setVisible(false);
			}
		});
	}

	//Restart the game game by resetting the view
	public void resetView()
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() 
			{
				//Setup main grid
				GridLayout contentLayout = new GridLayout(2, 2);
				contentLayout.setVgap(10);
				contentLayout.setHgap(10);
				
				//Set layout format
				getContentPane().setLayout(contentLayout);

				//Remove win or lose icons and buttons
				remove(game_end);
				remove(button_panel);

				//Add game components back
				add(targetContainerPanel);
				add(status);
				add(shipContainerPanel);
				add(shipBox);
		
				//Redraw view
				revalidate();
				repaint();
			}
		});
	}

	//Display game won screen
	public void displayWin()
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() 
			{
				//Stop the background music
				stopMusic();
				//Play winning sound effect
				playWin();

				//Remove game components from the view
				remove(targetContainerPanel);
				remove(status);
				remove(shipContainerPanel);
				remove(shipBox);

				//Setup new layout and icon game won graphic
				setLayout(new GridLayout(2, 1));
				game_end = new JLabel(sourceIcon("Graphics/GameWon.png"));  
				add(game_end);
				button_panel = new JPanel();
				
				//Setup margin between buttons
				GridBagConstraints c = new GridBagConstraints();
				c.insets = new Insets(5, 5, 5, 5);

				//Set background color of button panel
				button_panel.setLayout(new GridBagLayout());
				button_panel.setBackground(new Color(141, 153, 174));

				//Add exit and restart buttons to the button panel
				button_panel.add(exit_button, c);
				button_panel.add(restart_button, c);

				//Add button panel to the view
				add(button_panel);

				//Redraw view
				revalidate();
				repaint();
			}
		});
	}


	//Display game lost screen
	public void displayLoss()
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() 
			{
				//Stop the background music
				stopMusic();
				//Play losing sound effect
				playLose();

				//Remove game components from the view
				remove(targetContainerPanel);
				remove(status);
				remove(shipContainerPanel);
				remove(shipBox);

				//Setup new layout and icon game losing graphic
				setLayout(new GridLayout(2, 1));
				game_end = new JLabel(sourceIcon("Graphics/GameLost.png"));  
				add(game_end);
				button_panel = new JPanel();
				
				//Setup margin between buttons
				GridBagConstraints c = new GridBagConstraints();
				c.insets = new Insets(5, 5, 5, 5);

				//Set background color of button panel
				button_panel.setLayout(new GridBagLayout());
				button_panel.setBackground(new Color(141, 153, 174));

				//Add exit and restart buttons to the button panel
				button_panel.add(exit_button, c);
				button_panel.add(restart_button, c);

				//Add button panel to the view
				add(button_panel);

				//Redraw view
				revalidate();
				repaint();		
			}
		});
	}

	//Add a tile listener to the tiles
	public void addTileListener(ActionListener fire)
	{
		//Iterate through the 2D array of tiles and add a tile listener to each JButton
		for (JButton[] row: targetBoard)	
			for (JButton button: row)
				button.addActionListener(fire);
	}

	//Add restart listener to the restart button
	public void addRestartListener(ActionListener restart)
	{
		restart_button.addActionListener(restart);	
	}

	//Add exit listener to the exit button
	public void addExitListener(ActionListener exit)
	{
		exit_button.addActionListener(exit);	
	}
	
	//Return JButton at specified location within the grid
	public JButton getTargetButton(int row, int col)
	{
		return targetBoard[row][col];	
	}

	//Return JButton at specified location within the grid
	public JButton getShipButton(int row, int col)
	{
		return playerBoard[row][col];	
	}

	//Update a button at a specified location in the grid
	public void updateShipButton(int row, int col, Icon new_icon)
	{
		playerBoard[row][col].setIcon(new_icon);
	}

	//Getters for the JPanels holding the water and ship tiles
	public JPanel getTargetPanel() {return targetButtonPanel;}
	public JPanel getShipPanel() {return shipButtonPanel;}

	//Assign each index of the target board to a JButton
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

	//Assign each JButton a place in the ocean board
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

	//Create icon using the image URL
	public Icon sourceIcon(String str)
	{
		//Get the image URL
		URL img_url = getClass().getResource(str);

		//Create a buffered image
		BufferedImage buf_img = null;

		//Attempt to read in the image
		try
		{
			buf_img = ImageIO.read(img_url);
		}
		catch (IOException ex)
		{
			System.out.println(ex.toString());	
		}

		//Return the image as a new image icon
		return new ImageIcon(buf_img);
	}

	//Place the ships at random locations
	public void placeRandom(JLabel label)
	{
		//Downcast to ship label
		ShipLabel ship = (ShipLabel)label;
		
		//Get two random numbers (0-9)
		int row = ThreadLocalRandom.current().nextInt(0, 9 + 1); 
		int col = ThreadLocalRandom.current().nextInt(0, 9 + 1);

		//Get a direction, NORTH (0) or WEST (1)
	       	int direction = ThreadLocalRandom.current().nextInt(0, 1 + 1);

		//Used for ship values
		int length = 0;
		Icon up_sprites[] = null;
		Icon left_sprites[] = null;
		ShipType type = ship.getType();

		//Grab ship values
		length = ship.getLength();
		up_sprites = ship.getUpSprites();
		left_sprites = ship.getLeftSprites();

		//If we can't place, get a new value for x and y
		while (! model.getShipBoard().canPlace(row, col, direction, length))
		{
			row = ThreadLocalRandom.current().nextInt(0, 9 + 1);
			col = ThreadLocalRandom.current().nextInt(0, 9 + 1);
			direction = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		}

		//Holds the index of the ship array
		int index = 0;
		int ship_array_index = type.getIndex();
		//Place ship on the tiles
		switch(direction)
		{	
			case 0:	
				//Vertical case
				for (int i = row; i < row + length ; i++)
				{
					//Place each tile and update model
					playerBoard[i][col].setIcon(new CompoundIcon(sourceIcon("Graphics/Water/Water.png"), up_sprites[index]));
					index++;
				}

				//Place the ship on the board
				model.getShip(ship_array_index).placeShip(model.getShipBoard(), 0, row, col);
				break;
			case 1:		
				//Horizontal case
				for (int i = col; i < col + length ; i++)
				{
					//Place each tile and update model
					playerBoard[row][i].setIcon(new CompoundIcon(sourceIcon("Graphics/Water/Water.png"), left_sprites[index]));
					index++;
				}

				//Place the ship on the board
				model.getShip(ship_array_index).placeShip(model.getShipBoard(), 1, row, col);
				break;
		}	

		//Disable ship icons	
		ship.setEnabled(false);
		ship.setVisible(false);

		//Enable ready button
		setup_done.setEnabled(true);
		setup_done.setVisible(true);
	}
	
	//Play splash sound effect
	public void playSplash()
	{
		AudioClip sound_clip = Applet.newAudioClip(water_sound_url);
		sound_clip.play();
	}

	//Play incorrect placement sound
	public void playIncorrect()
	{
		AudioClip sound_clip = Applet.newAudioClip(incorrect_sound_url);
		sound_clip.play();
	}

	//Play impact sound
	public void playHit()
	{
		AudioClip sound_clip = Applet.newAudioClip(hit_sound_url);
		sound_clip.play();
	}

	//Play miss sound
	public void playMiss()
	{
		AudioClip sound_clip = Applet.newAudioClip(miss_sound_url);
		sound_clip.play();
	}

	//Play enemy inpact sound
	public void playEnemyHit()
	{
		AudioClip sound_clip = Applet.newAudioClip(enemy_hit_sound_url);
		sound_clip.play();
	}

	//Play enemy missed sound
	public void playEnemyMiss()
	{
		AudioClip sound_clip = Applet.newAudioClip(enemy_miss_sound_url);
		sound_clip.play();
	}

	//Play ship sinking sound
	public void playShipSunk()
	{
		AudioClip sound_clip = Applet.newAudioClip(ship_sunk_sound_url);
		sound_clip.play();
	}

	//Play background music continually
	public void startBackgroundMusic()
	{
		background_music = Applet.newAudioClip(music_sound_url);
		background_music.loop();
	}

	//Play game lost sound
	public void playLose()
	{
		AudioClip sound_clip = Applet.newAudioClip(lose_sound_url);
		sound_clip.play();
	}

	//Play game won sound
	public void playWin()
	{
		AudioClip sound_clip = Applet.newAudioClip(win_sound_url);
		sound_clip.play();
	}

	//Stop the background music
	public void stopMusic()
	{
		background_music.stop();
	}

	//Flash the image icon for a quick period of time
	public void flashIcon(ShipLabel ship, Icon normal, Icon error)
	{
		ship.setIcon(error);	

		long delay_time = 250; //Stored in milliseconds
		
		//When the timer ends, reset the icon
		TimerTask resetIcon = new TimerTask()
		{
			public void run()
			{
					ship.setIcon(normal);
			}
		};

		Timer reset_timer = new Timer();

		reset_timer.schedule(resetIcon, delay_time); //Start the timer  		
	}

	//Flash the ship icon and play an incorrect sound
	public void invalidPlacement(ShipLabel ship, int direction)
	{
		playIncorrect();
		
		//Flash the correct icon based to the ship's orientation
		switch(direction)
		{
			case 0:
				flashIcon(ship, ship.getUpIcon(), ship.getUpErrorIcon());
				break;

			case 1:
				flashIcon(ship, ship.getLeftIcon(), ship.getLeftErrorIcon());
				break;
		}
	}

//						INNER CLASSES
//|====================================================================================================|	
	
	//Try this way | This might be some of the weirdest code I've written but it works somehow ???
	//Each ship has its own class, inheriting the ship label class	
	
	//Destroyer Class
	class DesLabel extends ShipLabel
	{
		public DesLabel(int length, int direction, String up_resource, String left_resource, String up_error, String left_error)
		{
			//Call super class constructor
			super(up_resource, left_resource, up_error, left_error);
			
			//Set length, direction, and type
			this.length = length;
			this.direction = direction;
			this.type = ShipType.DESTROYER;

			//Create new arrays to hold icon squares
			up_sprites = new Icon[2];
			left_sprites = new Icon[2];

			//Get the up icons
			up_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/DestroyerTile1.png");	
			up_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/DestroyerTile2.png");

			//Get the left icons
			left_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/DestroyerLeftTile1.png");
			left_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/DestroyerLeftTile2.png");
		}	
	}

	//Battleship Class
	class CruLabel extends ShipLabel
	{
		public CruLabel(int length, int direction, String up_resource, String left_resource, String up_error, String left_error)
		{
			//Call super class constructor
			super(up_resource, left_resource, up_error, left_error);
			
			//Set length, direction, and type
			this.length = length;
			this.direction = direction;
			this.type = ShipType.CRUISER;

			//Create new arrays to hold icon squares
			up_sprites = new Icon[3];
			left_sprites = new Icon[3];

			//Get the up icons
			up_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/CruiserTile1.png");		
			up_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/CruiserTile2.png");	
			up_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/CruiserTile3.png");	
			
			//Get the left icons
			left_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/CruiserLeftTile1.png");	
			left_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/CruiserLeftTile2.png");	
			left_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/CruiserLeftTile3.png");	
		}
	}
	
	//Submarine Class
	class SubLabel extends ShipLabel
	{
		public SubLabel(int length, int direction, String up_resource, String left_resource, String up_error, String left_error)
		{
			//Call super class constructor
			super(up_resource, left_resource, up_error, left_error);
			
			//Set length, direction, and type
			this.length = length;
			this.direction = direction;
			this.type = ShipType.SUBMARINE;

			//Create new arrays to hold icon squares
			up_sprites = new Icon[3];
			left_sprites = new Icon[3];

			//Get the up icons
			up_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/SubmarineTile1.png");	
			up_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/SubmarineTile2.png");
			up_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/SubmarineTile3.png");

			//Get the left icons
			left_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/SubmarineLeftTile1.png");
			left_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/SubmarineLeftTile2.png");
			left_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/SubmarineLeftTile3.png");
		}	
	}	
	
	//Battleship Class
	class BatLabel extends ShipLabel
	{
		public BatLabel(int length, int direction, String up_resource, String left_resource, String up_error, String left_error)
		{

			//Call super class constructor
			super(up_resource, left_resource, up_error, left_error);
			
			//Set length, direction, and type
			this.length = length;
			this.direction = direction;
			this.type = ShipType.BATTLESHIP;

			//Create new arrays to hold icon squares
			up_sprites = new Icon[4];
			left_sprites = new Icon[4];

			//Get the up icons
			up_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/BattleshipTile1.png");	
			up_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/BattleshipTile2.png");	
			up_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/BattleshipTile3.png");	
			up_sprites[3] = sourceIcon("Graphics/Ships/ShipMod/BattleshipTile4.png");	
			
			//Get the left icons
			left_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/BattleshipLeftTile1.png");	
			left_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/BattleshipLeftTile2.png");
			left_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/BattleshipLeftTile3.png");
			left_sprites[3] = sourceIcon("Graphics/Ships/ShipMod/BattleshipLeftTile4.png");
		}
	}

	//Carrier Class
	class CarLabel extends ShipLabel
	{
		public CarLabel(int length, int direction, String up_resource, String left_resource, String up_error, String left_error)
		{
			//Call super class constructor
			super(up_resource, left_resource, up_error, left_error);

			//Set length, direction, and type
			this.length = length;
			this.direction = direction;
			this.type = ShipType.CARRIER;

			//Create new arrays to hold icon squares
			up_sprites = new Icon[5];
			left_sprites = new Icon[5];

			//Get the up icons
			up_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/CarrierTile1.png");	
			up_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/CarrierTile2.png");	
			up_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/CarrierTile3.png");	
			up_sprites[3] = sourceIcon("Graphics/Ships/ShipMod/CarrierTile4.png");	
			up_sprites[4] = sourceIcon("Graphics/Ships/ShipMod/CarrierTile5.png");	

			//Get the left icons
			left_sprites[0] = sourceIcon("Graphics/Ships/ShipMod/CarrierLeftTile1.png");
			left_sprites[1] = sourceIcon("Graphics/Ships/ShipMod/CarrierLeftTile2.png");
			left_sprites[2] = sourceIcon("Graphics/Ships/ShipMod/CarrierLeftTile3.png");
			left_sprites[3] = sourceIcon("Graphics/Ships/ShipMod/CarrierLeftTile4.png");
			left_sprites[4] = sourceIcon("Graphics/Ships/ShipMod/CarrierLeftTile5.png");
		}	
	}

	//Mouse listner for dragging the ship icons
	class DragShip extends MouseAdapter
	{
		//Stores the location of the mouse event
    		MouseEvent pressed;
		
		//Keep track of where the mouse is
		Component lastEntered;

		//Initalize ship information
		int direction = 0;
		int length = 0;
		Icon up_sprites[] = null;
		Icon left_sprites[] = null;
		ShipLabel ship = null;

		//Set index to 0 and assume the object is not a ship 
		int ship_array_index = 0; 
		boolean is_ship = false;

		//When mouse is pressed, get the location and store it
		@Override
		public void mousePressed(MouseEvent e)
		{
			pressed = e;	
		}

		//When the mouse is dragged, if the source is a ship get all the information
		@Override
		public void mouseDragged(MouseEvent e)
		{
			Object obj = e.getSource();
			if (obj instanceof JLabel)
			{
				//Get ship information
				ship = (ShipLabel)obj;
				direction = ship.getDirection();
				length = ship.getLength();
				up_sprites = ship.getUpSprites();
				left_sprites = ship.getLeftSprites();
				ship_array_index = ship.getType().getIndex();
				
				//The player is dragging a ship
				is_ship = true;
	
				//Update cursor icon
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		}	
	
		//Keep track of the last JButton that was hovered over
		public void mouseEntered(MouseEvent e)
		{
			//Set the last entered to the componet we are currently on
			lastEntered = e.getComponent();
		}
		
		@Override
		public void mouseReleased(MouseEvent e)
		{		
			//Reset the mouse cursor
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			//Check if the released location is a valid place to drop the ship
			if ((lastEntered instanceof JButton) && (is_ship == true))
			{
				//Get coordinates of the selected JButton
				JButton button = (JButton)lastEntered;
				String coords[] = button.getActionCommand().split(" ");
				Point point = new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
				int row = (int)point.getY();
				int col = (int)point.getX();

				if (model.getShipBoard().canPlace(row, col, direction, length))
				{
					//playSplash();	

					//Disable the ability to place randomly
					setup_random.setEnabled(false);
					setup_random.setVisible(false);

					//Index of the ship sprites
					int index = 0;

					switch(direction)
					{	
						case 0:	
							//Place ship on the selected tiles
							for (int i = row; i < row + length ; i++)
							{
								playerBoard[i][col].setIcon(new CompoundIcon(sourceIcon("Graphics/Water/Water.png"), up_sprites[index]));
								index++;
							}

							//Place ship on the corresponding model tiles
							model.getShip(ship_array_index).placeShip(model.getShipBoard(), 0, row, col);
							break;
						case 1:		
							//Place ship on the selected tiles
							for (int i = col; i < col + length ; i++)
							{
								playerBoard[row][i].setIcon(new CompoundIcon(sourceIcon("Graphics/Water/Water.png"), left_sprites[index]));	
								index++;
							}

							//Place ship on the corresponding model tiles
							model.getShip(ship_array_index).placeShip(model.getShipBoard(), 1, row, col);
							break;
					}	
		
					//Add one to ships placed
					ships_placed++;

					//Disable ship icons	
					ship.setEnabled(false);
					ship.setVisible(false);
				
					//Check if player has placed all their ships, if so enable the done button
					if (ships_placed == NUM_SHIPS)
					{
						setup_done.setEnabled(true);
						setup_done.setVisible(true);
					}

					//Play ship splash sound effect
					playSplash();
				}
				else
					//If the place was occupied, display to the user that their placement was not valid
					invalidPlacement(ship, direction);
			}
			//If the user attempted to place a ship off the grid display to the user that their placement was not valid
			else if (is_ship == true)
				invalidPlacement(ship, direction);
			
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

			//Play the splash sound effect
			playSplash();	

			//Disable the button
			button.setEnabled(false);
			button.setVisible(false);
		}
	}
}