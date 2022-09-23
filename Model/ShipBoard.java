public class ShipBoard
{
	public ShipBoard()
	{
		tiles = new Tile[10][10];
		isClickable = true;
	}

	public bool validBoard()
	{
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				if(tiles[i][j].getTileType() == OVERLAP)
					return false;
	}	

	public bool placeShip(Ship)
	{
		//Place a ship and check if valid
	}
}
