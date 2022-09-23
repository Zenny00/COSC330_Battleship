public class Tile
{
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
		if (TYPE == SHIP || TYPE == OVERLAP)
			TYPE = OVERLAP;
		else
			type = SHIP;
	}	

	public void addMiss()
	{
		type = MISS;
	}
}
