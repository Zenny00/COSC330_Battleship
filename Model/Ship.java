public class Ship
{
	private int size;
	private int numHits = 0;
	private Direction direction;
	private Tile origin;
	private	ShipType type;
	private boolean placed = false;

	Ship(ShipType type)
	{
		this.type = type;
		switch (type) {
			case SUBMARINE: 
				size = 3;
				break;
			case CRUISER: 
				size = 3;
				break;
			case DESTROYER:
				size = 2;
				break;
			case CARRIER:
				size = 5;
				break;
			case BATTLESHIP:
				size = 4;
				break;
		}
	}

	public void incrementHits(){numHits++;}

	public ShipType getType(){return type;}
	public boolean isSunk(){return size == numHits;}
	public boolean isPlaced(){return placed;}

	public boolean placeShip(Board input_board, Direction direction, int x, int y)
	{
		try {
			this.direction = direction;
			this.origin = input_board.getTile(x, y);
			switch(direction) {
				case NORTH: for(int i = 0; i < size; i++) input_board.getTile(x, y + i).addShip();
						    break;
				case SOUTH: for(int i = 0; i < size; i++) input_board.getTile(x, y - i).addShip();
						    break;
				case EAST:	for(int i = 0; i < size; i++) input_board.getTile(x, y + i).addShip();
							break;
				case WEST:	for(int i = 0; i < size; i++) input_board.getTile(x, y - i).addShip();
							break;
			}
		} catch(Exception nonTileException) { //Throws a nonTileException if the requested tile does not exist, returns false 
			return false;
		}
		return placed = true;
	}
}
