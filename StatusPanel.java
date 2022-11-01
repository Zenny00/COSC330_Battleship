//Name(s): Joshua Comfort & Justin Conklin
//Description: Displays the current status of the game

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

import javax.swing.border.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.*;
import java.awt.image.BufferedImage;

public class StatusPanel extends JPanel
{
	//Holds enemy ship icons
	private JPanel enemy_ship_box = new JPanel();
	
	//Holds player ship icons
	private JPanel friendly_ship_box = new JPanel();

	//Separate the two ship boxes
	private JPanel barrier = new JPanel();

	//Holds text for status headers
	private JLabel friendlyText = new JLabel();
	private JLabel enemyText = new JLabel();

	//Initialize JLabels to hold friendly ship icons
	private JLabel friendly_carrier; 
	private JLabel friendly_battleship; 
	private JLabel friendly_cruiser; 
	private JLabel friendly_submarine; 
	private JLabel friendly_destroyer; 
	
	//Initialize JLabels to hold enemy ship icons
	private JLabel enemy_carrier; 
	private JLabel enemy_battleship; 
	private JLabel enemy_cruiser; 
	private JLabel enemy_submarine; 
	private JLabel enemy_destroyer; 
	
	//Icons to hold friendly ship icons
	private Icon friendly_carrier_icon;
	private Icon friendly_battleship_icon;
	private Icon friendly_cruiser_icon;
	private Icon friendly_submarine_icon;
	private Icon friendly_destroyer_icon; 
	
	//Initialize JLabels to hold enemy ship icons
	private Icon enemy_carrier_icon;
	private Icon enemy_battleship_icon;
	private Icon enemy_cruiser_icon;
	private Icon enemy_submarine_icon; 
	private Icon enemy_destroyer_icon;

	//Icons to hold friendly destroyed ship icons
	private Icon friendly_carrier_destroyed_icon;
	private Icon friendly_battleship_destroyed_icon;
	private Icon friendly_cruiser_destroyed_icon;
	private Icon friendly_submarine_destroyed_icon;
	private Icon friendly_destroyer_destroyed_icon; 
	
	//Initialize JLabels to hold enemy destroyed ship icons
	private Icon enemy_carrier_destroyed_icon;
	private Icon enemy_battleship_destroyed_icon;
	private Icon enemy_cruiser_destroyed_icon;
	private Icon enemy_submarine_destroyed_icon; 
	private Icon enemy_destroyer_destroyed_icon;

	//Holds the root directory
	private final String ROOT_DIR = "Graphics/Status/";

	StatusPanel(Role role)
	{
		//Setup grid to hold text and icon trays
		GridLayout contentLayout = new GridLayout(5, 1);
		contentLayout.setVgap(10);
		contentLayout.setHgap(10);
		
		//Set the background color of the panel
		setBackground(Color.white);

		//Setup the layout of the two display panels
		friendly_ship_box.setLayout(new GridLayout(1, 5));
		enemy_ship_box.setLayout(new GridLayout(1, 5));

		//Set font
		Font text_font = new Font("Dialog", Font.BOLD, 25);

		//Set alignment
		friendlyText.setHorizontalAlignment(SwingConstants.CENTER);
		friendlyText.setFont(text_font);
		friendlyText.setText("PLAYER");
		friendlyText.setForeground(Color.white);

		//Set alignment
		enemyText.setHorizontalAlignment(SwingConstants.CENTER);
		enemyText.setFont(text_font);
		enemyText.setText("ENEMY");
		enemyText.setForeground(Color.white);

		//Give the JPanel the specified layout
		setLayout(contentLayout);

		//Setup all ship icons
		friendly_carrier_icon = sourceIcon(ROOT_DIR + "FriendlyCarrier.png");
		friendly_battleship_icon = sourceIcon(ROOT_DIR + "FriendlyBattleship.png");
		friendly_cruiser_icon = sourceIcon(ROOT_DIR + "FriendlyCruiser.png");
		friendly_submarine_icon = sourceIcon(ROOT_DIR + "FriendlySubmarine.png");
		friendly_destroyer_icon = sourceIcon(ROOT_DIR + "FriendlyDestroyer.png");

		enemy_carrier_icon = sourceIcon(ROOT_DIR + "EnemyCarrier.png");
		enemy_battleship_icon = sourceIcon(ROOT_DIR + "EnemyBattleship.png");
		enemy_cruiser_icon = sourceIcon(ROOT_DIR + "EnemyCruiser.png");
		enemy_submarine_icon = sourceIcon(ROOT_DIR + "EnemySubmarine.png"); 
		enemy_destroyer_icon = sourceIcon(ROOT_DIR + "EnemyDestroyer.png");

		friendly_carrier_destroyed_icon = sourceIcon(ROOT_DIR + "FriendlyCarrierDestroyed.png");
		friendly_battleship_destroyed_icon = sourceIcon(ROOT_DIR + "FriendlyBattleshipDestroyed.png");
		friendly_cruiser_destroyed_icon = sourceIcon(ROOT_DIR + "FriendlyCruiserDestroyed.png");
		friendly_submarine_destroyed_icon = sourceIcon(ROOT_DIR + "FriendlySubmarineDestroyed.png");
		friendly_destroyer_destroyed_icon = sourceIcon(ROOT_DIR + "FriendlyDestroyerDestroyed.png");
	
		enemy_carrier_destroyed_icon = sourceIcon(ROOT_DIR + "EnemyCarrierDestroyed.png");
		enemy_battleship_destroyed_icon = sourceIcon(ROOT_DIR + "EnemyBattleshipDestroyed.png");
		enemy_cruiser_destroyed_icon = sourceIcon(ROOT_DIR + "EnemyCruiserDestroyed.png");
		enemy_submarine_destroyed_icon = sourceIcon(ROOT_DIR + "EnemySubmarineDestroyed.png");
		enemy_destroyer_destroyed_icon = sourceIcon(ROOT_DIR + "EnemyDestroyerDestroyed.png");

		//Initialize JLabels for friendly ships
		friendly_carrier = new JLabel(friendly_carrier_icon); 
		friendly_battleship = new JLabel(friendly_battleship_icon); 
		friendly_cruiser = new JLabel(friendly_cruiser_icon); 
		friendly_submarine = new JLabel(friendly_submarine_icon); 
		friendly_destroyer = new JLabel(friendly_destroyer_icon); 
		
		//Initialize JLabels for enemy ships
		enemy_carrier = new JLabel(enemy_carrier_icon); 
		enemy_battleship = new JLabel(enemy_battleship_icon); 
		enemy_cruiser = new JLabel(enemy_cruiser_icon); 
		enemy_submarine = new JLabel(enemy_submarine_icon); 
		enemy_destroyer = new JLabel(enemy_destroyer_icon);

		//Add friendly ships to box
		friendly_ship_box.add(friendly_carrier);
		friendly_ship_box.add(friendly_battleship);
		friendly_ship_box.add(friendly_cruiser);
		friendly_ship_box.add(friendly_submarine);
		friendly_ship_box.add(friendly_destroyer);
		
		//Add enemy ships to box
		enemy_ship_box.add(enemy_carrier);
		enemy_ship_box.add(enemy_battleship);
		enemy_ship_box.add(enemy_cruiser);
		enemy_ship_box.add(enemy_submarine);
		enemy_ship_box.add(enemy_destroyer);
		
		//Set background color of ship boxes
		barrier.setBackground(new Color(0, 0, 80));
		friendly_ship_box.setBackground(new Color(0, 0, 80));
		enemy_ship_box.setBackground(new Color(0, 0, 80));

		//Add boxes to panel
		add(friendlyText);
		add(friendly_ship_box);
		add(enemy_ship_box);
		add(enemyText);
		add((JPanel)role);

		//Set background color 
		setBorder(new LineBorder(new Color(255, 255, 255), 3));
		setBackground(new Color(0, 0, 80));

		//Set dimensions and visibility
		setPreferredSize(new Dimension(400, 400));
		setVisible(true);

	}

	//Reset panel to initial state
	public void resetPanel()
	{
		friendly_carrier.setIcon(friendly_carrier_icon);
		friendly_battleship.setIcon(friendly_battleship_icon);
		friendly_cruiser.setIcon(friendly_cruiser_icon);
		friendly_submarine.setIcon(friendly_submarine_icon);
		friendly_destroyer.setIcon(friendly_destroyer_icon);

		enemy_carrier.setIcon(enemy_carrier_icon);
		enemy_battleship.setIcon(enemy_battleship_icon);
		enemy_cruiser.setIcon(enemy_cruiser_icon);
		enemy_submarine.setIcon(enemy_submarine_icon);
		enemy_destroyer.setIcon(enemy_destroyer_icon);
	}

	//Update enemy status
	public void enemyShipDestroyed(ShipType ship)
	{
		// SHIP TYPES
		/*
		DESTROYER(0),
		SUBMARINE(1),
		CRUISER(2),
		BATTLESHIP(3),
		CARRIER(4);
		*/

		//Change the icon of the passed ship
		switch(ship)
		{
			case CARRIER:
				enemy_carrier.setIcon(enemy_carrier_destroyed_icon);
				break;

			case BATTLESHIP:
				enemy_battleship.setIcon(enemy_battleship_destroyed_icon);
				break;

			case CRUISER:
				enemy_cruiser.setIcon(enemy_cruiser_destroyed_icon);
				break;

			case SUBMARINE:
				enemy_submarine.setIcon(enemy_submarine_destroyed_icon);
				break;

			case DESTROYER:
				enemy_destroyer.setIcon(enemy_destroyer_destroyed_icon);
				break;
		}			
	}

	//Update player status
	public void friendlyShipDestroyed(ShipType ship)
	{
		// SHIP TYPES
		/*
		DESTROYER(0),
		SUBMARINE(1),
		CRUISER(2),
		BATTLESHIP(3),
		CARRIER(4);
		*/

		//Change the icon of the passed ship
		switch(ship)
		{
			case CARRIER:
				friendly_carrier.setIcon(friendly_carrier_destroyed_icon);
				break;

			case BATTLESHIP:
				friendly_battleship.setIcon(friendly_battleship_destroyed_icon);
				break;

			case CRUISER:
				friendly_cruiser.setIcon(friendly_cruiser_destroyed_icon);
				break;

			case SUBMARINE:
				friendly_submarine.setIcon(friendly_submarine_destroyed_icon);
				break;

			case DESTROYER:
				friendly_destroyer.setIcon(friendly_destroyer_destroyed_icon);
				break;
		}			
	}

	//Stream icon from url
	public Icon sourceIcon(String str)
	{
		//Get URL
		URL img_url = getClass().getResource(str);

		//Create buffered image
		BufferedImage buf_img = null;

		//Attempt to load image
		try
		{
			buf_img = ImageIO.read(img_url);
		}
		catch (IOException ex)
		{
			System.out.println(ex.toString());	
		}

		//Return new image icon
		return new ImageIcon(buf_img);
	}
}