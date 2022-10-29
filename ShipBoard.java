//Name(s): Joshua Comfort & Justin Conklin
//Description: ShipBoard extending the board class

public class ShipBoard extends Board
{
	//Call the super class constructor
	public ShipBoard()
	{
		super();
	}

	//Check if the ship can be placed on the player's board
	public boolean canPlace(int row, int col, int direction, int length)
	{
		boolean canPlace = true;
		switch (direction)
		{
			case 0:
				//Check bounds
				if (row + length > BOARD_SIZE)
					return false;
				
				//Check if ship is already in wanted location
				for (int i = row; i < row + length ; i++)
				{	
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
					if (tiles[row][i].getTileType() == TileType.SHIP)
						canPlace = false;
				}
				break;
		}		

		//Return value
		return canPlace;
	}	
}
