public class Tile
{
	private int x;
	private int y;
	private TileType type;
	private bool clickable;

        //Various constructors taking different numbers of parameters 
	public Tile(){clickable = true; }
        public Tile(int x, int y) { this.x = x; this.y = y; type = SEA; }
        public Tile(int x, int y, TileType type) { this,x = x; this.y = y; this.type = type; }
        public Tile(int x, int y, TileType type, bool clickable) { this.x = x, this.y = y; this.type = type; this.clickable = clickable; }

	public bool isClickable(){return clickable;}
	public int getX(){return x;}
	public int getY(){return y;}
	public TileType getTileType(){return type;} 

	private void addHit(){type = HIT;}
	private void addMiss(){type = MISS;}
	public void setType(TileType status){type = status;}
        public void setClickability(bool clickability) { clickable = clickability; }

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
