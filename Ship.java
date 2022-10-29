//Name(s): Joshua Comfort & Justin Conklin
//Description: Model size of the ship implementation, holds the direction of the ship and the tiles it occupies

public class Ship
{
	//Data members for holding the ship size, number of hits, and direction
	private int size;
	private int numHits = 0;
	private int direction;

	//Holds the ship's type 
	private	ShipType type;

	//Holds the ships the ship occupies
	private Tile shipTiles[];

	//Ship constructor set up the ship size and create new array of tiles to hold the ship location
	Ship(ShipType type)
	{
		//Set the ship type and allocate size based on the type
		this.type = type;

		switch (type) {
			case DESTROYER:
				size = 2;
				shipTiles = new Tile[2];
				break;
			case SUBMARINE: 
				size = 3;
				shipTiles = new Tile[3];
				break;
			case CRUISER: 
				size = 3;	
				shipTiles = new Tile[3];
				break;
			case BATTLESHIP:
				size = 4;
				shipTiles = new Tile[4];
				break;
			case CARRIER:
				size = 5;
				shipTiles = new Tile[5];
				break;
		}
	}

	//Increase the number of hits for a ship
	public void incrementHits(){numHits++;}

	//Get the ship type
	public ShipType getType(){return type;}
	
	//Returns true if the ship has been sunk
	public boolean isSunk(){return size == numHits;}

	//When a shot is fired this function is called to see if a ship was hit
	public boolean checkTiles(int row, int column)
	{
		//Check each of the ship's tiles to see if they match the input coordinates
		for (int i = 0; i < size; i++)
		{
			//If one of the tiles matches, return true
			if ((shipTiles[i].getY() == column) && (shipTiles[i].getX() == row))
			{
				incrementHits();
				return true;
			}
		}

		//If none of the tiles match, return false
		return false;
	}

	//Places a ship at a specified location
	public void placeShip(ShipBoard input_board, int direction, int row, int col)
	{
		this.direction = direction;
		
		//Used to index the ship array
		int index = 0;

		//Two possible cases | CASE 0: ship is upright | CASE 1: CASE IS FACING LEFT
		switch(direction) 
		{
			case 0: 
				//Iterate through the allocated tiles
				for(int i = row; i < row + size; i++)  
				{
					//Set the tile type to ship
					input_board.getTile(i, col).addShip();
					//Add the tile to the ship's array of tiles
					shipTiles[index] = input_board.getTile(i, col);
					index++;
				}

				break;
			case 1:
				//Iterate through the allocated tiles
				for(int i = col; i < col + size; i++)
				{
					//Set the tile type to ship
					input_board.getTile(row, i).addShip();
					//Add the tile to the ship's array of tiles
					shipTiles[index] = input_board.getTile(row, i);
					index++;
				}
					
				break;
		}
	} 
}
