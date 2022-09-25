public class Ship
{
	private int size;
	private int numHits;
	private Direction direction;
	private Tile origin;
	private	ShipType type;
	private bool placed;

	Ship(int size, int numHits, Direction direction, Tile origin, ShipType type)
	{
		this.size = size;
		this.numHits = numHits;
		this.direction = direction;
		this.origin = origin;
		this.type = type;
		placed = false;
	}

	public void incrementHits(){numHits++;}

	public ShipType getType(){return type;}
	public bool isSunk(){return size == numHits;}
	public bool isPlaced(){return placed;}

	public bool placeShip(Board input_board, Direction direction, int x, int y)
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
