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
	public boolean canPlace(int row, int col, int direction, int length)
	{
		boolean canPlace = true;
		System.out.println("Checking case " + direction);
		switch (direction)
		{
			case 0:
				//Check bounds
				if (row + length > BOARD_SIZE)
					return false;
				
				//Check if ship is already in wanted location
				for (int i = row; i < row + length ; i++)
				{
					System.out.println("x: " + col + " y: " + i);	
				
					if (tiles[i][col].getTileType() == TileType.SHIP)
						canPlace = false;
				}
				break;
			case 1:
				//Check bounds
				if (col + length > BOARD_SIZE)
					return false;
				
				//Check if ship is already in wanted location
				for (int i = col; i < col + length; i++)
				{
					System.out.println("x: " + i + " y: " + row);	
				
					if (tiles[row][i].getTileType() == TileType.SHIP)
						canPlace = false;
				}
				break;
		}		

		//Return value
		return canPlace;
	}	
}
