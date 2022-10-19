public class javaPaste
{
	public static void main(String args[])
	{
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				System.out.println("private JButton ship_i" + i + "j" + j + "= new JButton();");

		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				System.out.println("enemyBoard[" + i + "][" + j + "] = target_i" + i + "j" + j + ";");

	}
}
