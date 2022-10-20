package model;

public class Tile
{
	private int x;
	private int y;
	private TileType type;
	private boolean clickable;

        //Various constructors taking different numbers of parameters 
	public Tile(){clickable = true; }
	public Tile(int x, int y) { this.x = x; this.y = y; type = TileType.SEA; }
	public Tile(int x, int y, TileType type) { this.x = x; this.y = y; this.type = type; }
	public Tile(int x, int y, TileType type, boolean clickable) { this.x = x; this.y = y; this.type = type; this.clickable = clickable; }

	public boolean isClickable(){return clickable;}
	public int getX(){return x;}
	public int getY(){return y;}
	public TileType getTileType(){return type;} 

	private void addHit(){type = TileType.HIT;}
	private void addMiss(){type = TileType.MISS;}
	public void setType(TileType status){type = status;}
	public void setClickability(boolean clickability) { clickable = clickability; }

	public TileType addShot() {
		if (type == TileType.SHIP)
			this.addHit();
		else if (type == TileType.SEA)
			this.addMiss();
		clickable = false;
		return type;
	}
	public void addShip() throws overlapException
	{
		if (type == TileType.SHIP)
			throw new overlapException("This placement overlaps with another ship");
		else
			type = TileType.SHIP;
	}	
}

class overlapException extends Exception 
{
	public overlapException(String s)
	{
		super(s);
	}
}