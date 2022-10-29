//Name(s): Joshua Comfort & Justin Conklin
//Description: Tile class, holds information for each of the squares on the ship and target boards

public class Tile
{
	//Two coordiantes
	private int x;
	private int y;

	//Holds the type of tile and its clickable status
	private TileType type;
	private boolean clickable;

        //Various constructors taking different numbers of parameters 
	public Tile(){clickable = true; }
	public Tile(int x, int y) { this.x = x; this.y = y; type = TileType.SEA; clickable = true; }
	public Tile(int x, int y, TileType type) { this.x = x; this.y = y; this.type = type; }
	public Tile(int x, int y, TileType type, boolean clickable) { this.x = x; this.y = y; this.type = type; this.clickable = clickable; }

	//Getters for clickability, x and y, and type
	public boolean isClickable(){return clickable;}
	public int getX(){return x;}
	public int getY(){return y;}
	public TileType getTileType(){return type;} 

	//Setters for type and clickability
	private void addHit(){type = TileType.HIT;}
	private void addMiss(){type = TileType.MISS;}
	public void setType(TileType status){type = status;}
	public void setClickability(boolean clickability) { clickable = clickability; }

	//Set type to shot
	public TileType addShot() {
		if (type == TileType.SHIP)
			this.addHit();
		else if (type == TileType.SEA)
			this.addMiss();
		clickable = false;
		return type;
	}

	//Set tile type to ship
	public void addShip() {
		type = TileType.SHIP;
	}	
}
