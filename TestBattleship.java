//JUnit testing for Java Battleship
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;

public class TestBattleship
{
	//Fail case
	@Test
	public void testFail()
	{
		fail("Tests failed!");
	}

	//Pass case
	@Test
	public void testTrue()
	{
		assertTrue(true);
	}
}
