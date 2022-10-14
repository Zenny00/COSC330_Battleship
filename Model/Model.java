public class Model
{
	private Ship ship_list[];
	private ShipBoard ocean_board;
	private Board target_board;
	//private String ip_address;

	Model()
	{	
		ship_list = new Ship[5];
		ship_list[0] = new Ship(ShipType.SUBMARINE);
		ship_list[1] = new Ship(ShipType.CRUISER);
		ship_list[2] = new Ship(ShipType.DESTROYER);
		ship_list[3] = new Ship(ShipType.CARRIER);
		ship_list[4] = new Ship(ShipType.BATTLESHIP);

		ocean_board = new ShipBoard();
		target_board = new Board();
	}

	//public void setIP(String ip_address){this.ip_address = ip_address;}

	public void setBoard(boolean valid) {
		ShipType selection = null;
		int x = 0, y = 0;
		Direction direction = null;

		while (this.hasPlacementsRemaining()) {
			// read in shiptype, direction, x, y
			switch(selection) {
				case SUBMARINE: ship_list[0].placeShip(ocean_board, direction, x, y);
					break;
				case CRUISER: ship_list[1].placeShip(ocean_board, direction, x, y);
					break;
				case DESTROYER: ship_list[2].placeShip(ocean_board, direction, x, y);
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
	public void updateBoard(int x, int y, TileType status) throws nonTileException
	{
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
	public TileType fireShot(Board input_board, int x, int y) throws nonTileException 
	{
		Tile target = input_board.getTile(x, y);
		TileType status = target.addShot();
		return status;
	}

	public boolean hasLost() {
		for (Ship currentShip : ship_list)
			if (!currentShip.isSunk())
			       return false;
		return true;	
	}
	public boolean hasPlacementsRemaining() {
		for (Ship currentShip : ship_list)
			if (!currentShip.isPlaced())
				return true;
		return false;
	}

	public boolean validTarget(int x, int y){return ocean_board.getClickable(x, y);}
	
	/*
        public void sendMessage(ostream os)
        {
              //Send message through the server
        }
	*/
}
