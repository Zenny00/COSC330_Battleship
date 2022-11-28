//JUnit testing for Java Battleship
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestBattleship
{
	//Test if the ships are being created using the proper type
	@Test
	public void testShipCreationType()
	{
		//Create new ship of type destroyer
		Ship newShip = new Ship(ShipType.DESTROYER);
		assertEquals(ShipType.DESTROYER, newShip.getType());
	}
}
