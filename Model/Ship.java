public class Ship
{
	public enum ShipType
	{
		SUBMARINE,
		CRUSIER,
		DESTROYER,
		CARRIER,
		BATTLESHIP
	};

	public enum Direction
	{
		EAST,
		WEST,
		NORTH,
		SOUTH
	};

	private int size;
	private int numHits = 0;
	private Direction direction;
	private Tile origin;
	private	ShipType type;
	private bool placed = false;

	Ship(ShipType type)
	{
		this.type = type;
		switch (type) {
			case (ShipType.SUBMARINE):size = 3;
				break;
			case (ShipType.CRUSIER):size = 3;
				break;
			case (ShipType.DESTROYER):size = 2;
				break;
			case (ShipType.CARRIER):size = 5;
				break;
			case (ShipType.BATTLESHIP):size = 4;
				break;
		}
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
