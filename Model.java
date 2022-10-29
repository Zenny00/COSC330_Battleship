import java.lang.Math;
import java.util.*;

public class Model
{
	private final int NUM_SHIPS = 5;
	private Ship ship_list[];
	private ShipBoard ocean_board;
	private Board target_board;
	private Random random = new Random();

	Model()
	{	
		ship_list = new Ship[NUM_SHIPS];
		
		//Setup the ship array
		ship_list[0] = new Ship(ShipType.DESTROYER);
		ship_list[1] = new Ship(ShipType.SUBMARINE);
		ship_list[2] = new Ship(ShipType.CRUISER);
		ship_list[3] = new Ship(ShipType.BATTLESHIP);
		ship_list[4] = new Ship(ShipType.CARRIER);
		
		ocean_board = new ShipBoard();
		target_board = new Board();
	}
	
	//Reset ship locations to inital state
	public void resetShips()
	{
		ship_list[0] = new Ship(ShipType.DESTROYER);
		ship_list[1] = new Ship(ShipType.SUBMARINE);
		ship_list[2] = new Ship(ShipType.CRUISER);
		ship_list[3] = new Ship(ShipType.BATTLESHIP);
		ship_list[4] = new Ship(ShipType.CARRIER);
	}

	//Reset ocean
	public void resetOcean()
	{
		ocean_board.resetBoard();
	}

	// For us in updated ocean_board since target_board 
	// should be updated when fireShot() is called
	public void updateBoard(int x, int y, TileType status) throws nonTileException
	{
		ocean_board.getTile(x, y).setType(status);
	}

	//Returns the model ship board
	public ShipBoard getShipBoard(){return ocean_board;}

	//Returns the model target board
	public Board getTargetBoard(){return target_board;}
	
	//Check each ship for possible hit, return the type of ship found, needed to display game status
	public ShipType checkShips(int row, int column)
	{
		for (Ship currentShip : ship_list)
			if (currentShip.checkTiles(row, column))
				return currentShip.getType(); 

		return null;
	}

	//Update clickability on model board
	public void fireShot(int row, int column) 
	{
		target_board.setNoClick(row, column);
	}

	//Check if all the player's ships are sunk
	public boolean hasLost() {
		for (Ship currentShip : ship_list)
		{
			boolean sunk = currentShip.isSunk();
			System.out.println(sunk);
			if (!sunk)
			       return false;
		}
		return true;	
	}

	//Check if shot has been fired here before	
	public boolean validTarget(int row, int column){return target_board.getClickable(row, column);}

	//Get ship from list
	public Ship getShip(int index)
	{
		//Return the ship at the given index
		return ship_list[index];
	}	
}
