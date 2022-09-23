public class Board
{
	private Tile tiles[][];
	private bool isClickable;

	public Board()
	{
		tiles = new Tile[10][10];
		isClickable = false;
	}

	public Tile getTile(int x, int y)
	{
		if (x <= 9 && y <= 9)
			return tiles[x-1][y-1];
		else
		{
			throw new nonTileException("Tile does not exist");
		}
	}	
}

class nonTileException extends Exception
{
	public nonTileException(String s)
	{
		super(s);
	}
}
