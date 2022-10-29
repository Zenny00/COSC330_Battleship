//Name(s): Joshua Comfort & Justin Conklin
//Description: ShipType enum

public enum ShipType
{
	//Use integer to index ship array
	DESTROYER(0),
	SUBMARINE(1),
	CRUISER(2),
	BATTLESHIP(3),
	CARRIER(4);

	//Holds ship index
	private final int index;

	//Private constructor
	private ShipType(int index)
	{
		this.index = index;
	}

	//Return the index
	public int getIndex()
	{
		return index;
	}
};
