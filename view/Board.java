public class Board
{
	protected final int BOARD_SIZE = 10;
	protected Tile tiles[][];

	public Board()
	{
		//Initialize all tiles to SEA with proper coordiantes
		tiles = new Tile[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++)
			for (int j = 0; j < BOARD_SIZE; j++)
				tiles[i][j] = new Tile(i, j);
	}
	
	public Tile getTile(int x, int y) throws nonTileException
	{
		if (x <= 9 && y <= 9)
			return tiles[x][y];
		else
		{
			throw new nonTileException("Tile does not exist");
		}
	}

	public boolean getClickable(int x, int y){return tiles[x][y].isClickable();}
}

//An exception if the player tries to access a tile that doesn't exist
class nonTileException extends Exception
{
	public nonTileException(String s)
	{
		super(s);
	}
}
