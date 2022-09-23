public class Player
{
	private Ship ship_list[];
	private ShipBoard ocean_board;
	private Board target_board;
	private string ip_address;

	Player()
	{	
		ship_list = new Ship[5];
		ship_list[0] = new Submarine();
		ship_list[1] = new PatrolBoat();
		ship_list[2] = new Destroyer();
		ship_list[3] = new AircraftCarrier();
		ship_list[4] = new Battleship();

		ocean_board = new ShipBoard();
		target_board = new Board();
	}

	public void setIP(string ip_address)
	{
		this.ip_address = ip_address;
	}

	public void setBoard(bool)
	{

	}

	public void updateBoard(Board input_board, int x, int y)
	{

	}

	public void fireShot(Board input_board, int x, int y)
	{

	}

	public bool hasLost()
	{
		for (Ship currentShip : ship_list)
			if (!currentShip.isSunk())
			       return false;

		return true;	
	}

	public int getRemainingShips()
	{
		int ship_count = 0;

		for (Ship currentShip : ship_list)
			if (!currentShip.isSunk())
				ship_count++;

		return ship_count;
	}
}
