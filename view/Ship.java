public class Ship
{
	private int size;
	private int numHits = 0;
	private Direction direction;
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

	public boolean placeShip(ShipBoard input_board, Direction direction, int x, int y)
	{
		try {
			this.direction = direction;
			this.origin = input_board.getTile(x, y);
			
			//Used to index the ship array
			int index = 0;
			
			switch(direction) 
			{
				case NORTH: 	
					for(int i = y; i < y + size; i++)  
					{
						input_board.getTile(i, x).addShip();
						shipTiles[index] = input_board.getTile(i, x);
						index++;
					}

					break;
				case WEST: 
					for(int i = x; i < x + size; i++)
					{
						input_board.getTile(y, i).addShip();
						shipTiles[index] = input_board.getTile(y, i);
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
