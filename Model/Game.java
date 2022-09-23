public class BattleshipGame
{
	private Player player_list[];
	private int current_turn;

	public void startGame(string player1_ip, string player2_ip)
	{
		player_list[0].setIP(player1_ip);
		player_list[1].setIP(player2_ip);
		Player active_player = player_list[0];
		Player next_player = player_list[1];
		int x, y; // x and y should be constrained somehow to valid limits

		// SETTING PHASE
		// next two lines should run in parallel hopefully
		active_player.setBoard();
		next_player.setBoard();

		// This is the gameplay loop
		while (!(player_list[0].hasLost()) && !(player_list[1].hasLost()))
		{
			active_player = player_list[current_player];
			next_player = player_list[current_player ^ 1];

			// COMBAT PHASE
			// read in player tile selection as x, y coordinates
			while (!checkHit(active_player, next_player, x, y))
				// read in player selection
			// output result to chat
			
			// TURN TRANSITION
			// this line of code toggles between 1 and 0 by using XOR operation
			// 0 ^ 1 = 1
			// 1 ^ 1 = 0
			current_turn ^= 1;
		}
		// output winner to chat
		// active_player is the winner
	}

	public bool checkHit(Player current_player, Player target_player, int x, int y)
	{
		if (!target_player.validTarget(x,y))
			return false;
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
