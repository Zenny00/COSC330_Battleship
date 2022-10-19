package model;

public class ShipBoard extends Board
{
	public ShipBoard(){tiles = new Tile[10][10];}

	public boolean validBoard()
	{
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				if(tiles[i][j].getTileType() == TileType.OVERLAP)
					return false;

		return true;
	}	
}
