package model;

public class Ship
{
	private int size;
	private int numHits = 0;
	private Direction direction;
	private Tile origin;
	private	ShipType type;
	private boolean placed = false;
	private String[] icons; //Possible idea for handling icons, or we go back to subclasses
	private String baseIcon;

	Ship(ShipType type)
	{
		// TODO: turn into a constant later
		String base = "../View/Graphics/Ships/ShipMod/";
		this.type = type;
		switch (type) {
			case SUBMARINE: 
				size = 3;
				icons = new String[]{base + "SubmarineTile1.png",
									 base + "SubmarineTile2.png",
									 base + "SubmarineTile3.png"};
				baseIcon = "../View/Graphics/Ships/Submarine.png";
				break;
			case CRUISER: 
				size = 3;
				break;
			case DESTROYER:
				size = 2;
				icons = new String[]{base + "DestroyerTile1.png",
									 base + "DestroyerTIle2.png"};
				baseIcon = "../View/Graphics/Ships/Destroyer.png";
				break;
			case CARRIER:
				size = 5;
				break;
			case BATTLESHIP:
				size = 4;
				break;
		}
	}

	public void incrementHits(){numHits++;}

	public ShipType getType(){return type;}
	public String[] getIcons() {return icons;}
	public String getBaseIcon() {return baseIcon;}
	public boolean isSunk(){return size == numHits;}
	public boolean isPlaced(){return placed;}

	public boolean placeShip(ShipBoard input_board, Direction direction, int x, int y)
	{
		try {
			this.direction = direction;
			this.origin = input_board.getTile(x, y);
			switch(direction) {
				case NORTH: for(int i = 0; i < size; i++) input_board.getTile(x, y + i).addShip();
						    break;
				case SOUTH: for(int i = 0; i < size; i++) input_board.getTile(x, y - i).addShip();
						    break;
				case EAST:	for(int i = 0; i < size; i++) input_board.getTile(x, y + i).addShip();
							break;
				case WEST:	for(int i = 0; i < size; i++) input_board.getTile(x, y - i).addShip();
							break;
			}
		} catch(Exception nonTileException) { //Throws a nonTileException if the requested tile does not exist, returns false 
			return false;
		}
		return input_board.isValid();
	}
}
