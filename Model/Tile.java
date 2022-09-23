public class Tile
{
	private int x;
	private int y;
	private TileType type;
	private bool clickable;

	Tile(){clickable = true;}

	public bool isClickable(){return clickable;}
	public int getX(){return x;}
	public int getY(){return y;}
	public TileType getTileType(){return type;}

	private void addHit(){type = HIT;}
	private void addMiss(){type = MISS;}
	public void setType(TileType status){type = status;}

	public TileType addShot() {
		if (type == SHIP)
			this.addHit();
		else if (type == SEA)
			this.addMiss();
		clickable = false;
		return type;
	}
	public void addShip() {
		if (type == SHIP || type == OVERLAP)
			type = OVERLAP;
		else
			type = SHIP;
	}	
}
