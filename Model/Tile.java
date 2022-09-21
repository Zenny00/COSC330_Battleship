public class Tile
{
	enum TileType
	{
		SHIP,
		SEA,
		HIT,
		MISS
	};

	private int x;
	private int y;
	private TileType type;

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public TileType getTileType()
	{
		return type;
	}

	public void addHit()
	{
		type = HIT;
	}

	public void addShip()
	{
		type = SHIP;
	}	
}
