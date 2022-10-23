public class Board
{
	protected final int BOARD_SIZE = 10;
	protected Tile tiles[][];

	public Board()
	{
		//Initialize all tiles to SEA with proper coordiantes
		tiles = new Tile[BOARD_SIZE][BOARD_SIZE];
		for (int row = 0; row < BOARD_SIZE; row++)
			for (int column = 0; column < BOARD_SIZE; column++)
				tiles[row][column] = new Tile(row, column);
	}
	
	public Tile getTile(int row, int column) //throws nonTileException
	{
		if (row < 10 && column < 10)
			return tiles[row][column];
		else
			return null;
		
		//throw new nonTileException("Tile does not exist");
	}

	public boolean getClickable(int row, int column){return tiles[row][column].isClickable();}
}

//An exception if the player tries to access a tile that doesn't exist
class nonTileException extends Exception
{
	public nonTileException(String s)
	{
		super(s);
	}
}
