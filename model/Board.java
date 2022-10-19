package model;

public class Board
{
	protected Tile tiles[][];

	public Board(){tiles = new Tile[10][10];}

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
