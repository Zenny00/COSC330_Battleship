public class Ship
{
	private int size;
	private int numHits = 0;
	private int direction;
	private Tile origin;
	private	ShipType type;
	private boolean placed = false;
	private Tile shipTiles[];

	Ship(ShipType type)
	{
		// TODO: turn into a constant later
		String base = "../View/Graphics/Ships/ShipMod/";
		this.type = type;
		switch (type) {
			case SUBMARINE: 
				size = 3;
				shipTiles = new Tile[3];
				break;
			case CRUISER: 
				size = 3;	
				shipTiles = new Tile[3];
				break;
			case DESTROYER:
				size = 2;
				shipTiles = new Tile[2];
				break;
			case CARRIER:
				size = 5;
				shipTiles = new Tile[5];
				break;
			case BATTLESHIP:
				size = 4;
				shipTiles = new Tile[4];
				break;
		}
	}

	public void incrementHits(){numHits++;}

	public ShipType getType(){return type;}
	public boolean isSunk(){return size == numHits;}
	public boolean isPlaced(){return placed;}

	public boolean checkTiles(int row, int column)
	{
		//Check each of the ship's tiles to see if they match the input coordinates
		for (int i = 0; i < size; i++)
		{
			System.out.println(type.toString() + " Row: " + shipTiles[i].getX() + " Column: " + shipTiles[i].getY());
			//If one of the tiles matches, return true
			if ((shipTiles[i].getY() == column) && (shipTiles[i].getX() == row))
			{
				incrementHits();
				System.out.println(type.toString() + " num hits: " + numHits);
				return true;
			}
		}

		//If none of the tiles match, return false
		return false;
	}

	public boolean placeShip(ShipBoard input_board, int direction, int row, int col)
	{
		try {
			this.direction = direction;
			this.origin = input_board.getTile(row, col);
			
			//Used to index the ship array
			
			int index = 0;
			switch(direction) 
			{
				case 0: 
					for(int i = row; i < row + size; i++)  
					{
						
						input_board.getTile(i, col).addShip();
						shipTiles[index] = input_board.getTile(i, col);
						index++;
					}

					break;
				case 1:
					for(int i = col; i < col + size; i++)
					{
						input_board.getTile(row, i).addShip();
						shipTiles[index] = input_board.getTile(row, i);
						index++;
					}
						
					break;

				//Not needed right now
				/*
				 case SOUTH: 
					for(int i = 0; i < size; i++) 
					{
						input_board.getTile(x, y - i).addShip();
					}
					
					break;
				case EAST: 
					for(int i = 0; i < size; i++) input_board.getTile(x, y + i).addShip();
						break;
				*/
			}
		} catch(Exception nonTileException) { //Throws a nonTileException if the requested tile does not exist, returns false 
			return false;
		}
		return input_board.validBoard();
	}
}
