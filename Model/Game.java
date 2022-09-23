public class BattleshipGame
{
	private Player player_list[];
	private int current_turn;

	public void startGame(string player1_ip, string player2_ip)
	{
		player_list[0].setIP(player1_ip);
		player_list[1].setIP(player2_ip);

		// This is the gameplay loop
		while (!(player_list[0].hasLost()) && !(player_list[1].hasLost()))
		{
			

			// this line of code toggles between 1 and 0 by using XOR operation
			// 0 ^ 1 = 1
			// 1 ^ 1 = 0
			current_turn ^= 1;
		}
	}

	public bool checkHit(Player current_player, Player target_player, int x, int y)
	{
		TileType status = current_player.fireShot(target_player.getShipBoard(), x, y);
		current_player.updateBoard(x, y, status);
	}

	BattleshipGame()
	{
		current_turn = 0;
		player_list = new Player[2];

		// TODO: get player_ip from client/server interaction
		// startGame(player1_ip, player2_ip);

	}
}
