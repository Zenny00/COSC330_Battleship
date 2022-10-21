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

	private ShipType(int index)
	{
		this.index = index;
	}

	public int getIndex()
	{
		return index;
	}
};
