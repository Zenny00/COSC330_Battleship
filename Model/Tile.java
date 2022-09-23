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

	private void addHit()
	{
		type = HIT;
	}

	private void addMiss()
	{
		type = MISS;
	}

	public void addShot()
	{
		if (type == SHIP)
			this.addHit();
		else if (type == SEA)
			this.addMiss();
	}

	public void addShip()
	{
		if (type == SHIP || type == OVERLAP)
			type = OVERLAP;
		else
			type = SHIP;
	}	


}
