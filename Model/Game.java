public class BattleshipGame
{
	private Player player_list[];
	private int current_turn;

	public void startGame(string player1_ip, string player2_ip)
	{
		// TODO: get player_ip from client/server interaction
		player_list[0].setIP(player1_ip);
		player_list[1].setIP(player2_ip);

		while (!(player_list[0].hasLost()) && !(player_list[1].hasLost()))
		{
			

			// this line of code toggles between 1 and 0 by using XOR operation
			// 0 ^ 1 = 1
			// 1 ^ 1 = 0
			current_turn ^= 1;
		}
	}

	public bool checkHit(Player player1, Player player2)
	{

	}

	BattleshipGame()
	{
		current_turn = 0;
		player_list = new Player[2];
	}
}
