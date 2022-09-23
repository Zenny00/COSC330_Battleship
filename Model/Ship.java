public class Ship
{
	private int size;
	private int numHits;
	private Direction direction;
	private Tile origin;
	private	ShipType type;

	Ship(int size, int numHits, Direction direction, Tile origin, ShipType type)
	{
		this.size = size;
		this.numHits = numHits;
		this.direction = direction;
		this.origin = origin;
		this.type = type;
	}

	public void incrementHits()
	{
		numHits++;
	}

	public ShipType getType()
	{
		return type;
	}

	public bool isSunk()
	{
		return size == numHits;
	}

	public bool placeShip(Board input_board, Direction direction, int x, int y)
	{
		try {
			this.direction = direction;
			this.origin = input_board.getTile(x, y);
			switch(direction) {
				case NORTH: for(int i = 0; i < size; i++) input_board.getTile(x, y + i).addShip();
				case SOUTH: for(int i = 0; i < size; i++) input_board.getTile(x, y - i).addShip();
				case EAST:	for(int i = 0; i < size; i++) input_board.getTile(x, y + i).addShip();
				case WEST:	for(int i = 0; i < size; i++) input_board.getTile(x, y - i).addShip();
			}
		} catch(Exception out_of_bounds) { // TODO update exception to whatever it should be
			return false;
		}
		return true;
	}
}
