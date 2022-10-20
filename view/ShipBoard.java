public class ShipBoard extends Board
{
	public ShipBoard()
	{
		super();
	}

	public boolean validBoard()
	{
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				if(tiles[i][j].getTileType() == TileType.OVERLAP)
					return false;

		return true;
	}	

	//Check if the ship can be placed on the player's board
	public boolean canPlace(int x, int y, int direction, int length)
	{
		boolean canPlace = true;
		System.out.println("Checking case " + direction);
		switch (direction)
		{
			case 0:
				//Check bounds
				if (y + length > BOARD_SIZE)
					return false;
				
				//Check if ship is already in wanted location
				for (int i = y; i < y + length ; i++)
					if (tiles[i][x].getTileType() == TileType.SHIP)
						canPlace = false;
				break;
			case 1:
				//Check bounds
				if (x + length > BOARD_SIZE)
					return false;
				
				//Check if ship is already in wanted location
				for (int i = x; i < x + length; i++)
					if (tiles[y][i].getTileType() == TileType.SHIP)
						canPlace = false;
				break;
		}		

		//Return value
		return canPlace;
	}	
}
