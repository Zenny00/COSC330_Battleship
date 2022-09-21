public class Ship
{
	enum ShipType
	{
		SUBMARINE,
		CRUSIER,
		DESTROYER,
		CARRIER,
		BATTLESHIP
	};

	private int size;
	private int numHits;
	private int direction;
	private Tile origin;
	private	ShipType type;

	Ship(int size, int numHits, int direction, Tile origin, ShipType type)
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

	public bool placeShip(Tile location, Board input_board, int x, int y)
	{

	}
}
