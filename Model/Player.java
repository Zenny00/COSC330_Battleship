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
		ship_list[1] = new Cruiser();
		ship_list[2] = new Destroyer();
		ship_list[3] = new AircraftCarrier();
		ship_list[4] = new Battleship();

		ocean_board = new ShipBoard();
		target_board = new Board();
	}

	public void setIP(string ip_address){this.ip_address = ip_address;}

	public void setBoard(bool) {
		ShipType selection;
		int x, y;
		Direction direction;

		while (this.hasPlacementsRemaining()) {
			// read in shiptype, direction, x, y
			switch(selection) {
				case SUBMARINE: ship_list[0].placeShip(ocean_board, direction, x, y);
					break;
				case CRUISER: ship_list[1].placeShip(ocean_board, direction, x, y);
					break;
				case DESTOYER: ship_list[2].placeShip(ocean_board, direction, x, y);
					break;
				case CARRIER: ship_list[3].placeShip(ocean_board, direction, x, y);
					break;
				case BATTLESHIP: ship_list[4].placeShip(ocean_board, direction, x, y);
					break;
			}
		}
	}

	// For us in updated ocean_board since target_board 
	// should be updated when fireShot() is called
	public void updateBoard(int x, int y, TileType status){
		ocean_board.getTile(x, y).setType(status);
	}

	public ShipBoard getShipBoard(){return ocean_board;}
	public Board getTargetBoard(){return target_board;}
	public int getRemainingShips(){
		int ship_count = 0;

		for (Ship currentShip : ship_list)
			if (!currentShip.isSunk())
				ship_count++;
		return ship_count;
	}

	// input_board should be the enemy sea board I think
	public TileType fireShot(Board input_board, int x, int y) {
		Tile target = input_board.getTile(x, y);
		TileType status = target.addShot();
		return status;
	}

	public bool hasLost() {
		for (Ship currentShip : ship_list)
			if (!currentShip.isSunk())
			       return false;
		return true;	
	}
	public bool hasPlacementsRemaining() {
		for (Ship currentShip : ship_list)
			if (!currentShip.isPlaced())
				return true;
		return false;
	}

	public bool validTarget(int x, int y){return ocean_board.getClickable(x, y);}
}