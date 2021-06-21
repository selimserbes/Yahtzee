package homework3;

public class Game_Management {

	public void game_loop() {
		//My queues and variables
		Queue Player_1 = new Queue(10000);
		Queue Player_2 = new Queue(10000);
		int loop_count = 0;
		int player1_score = 0;
		int player2_score = 0;
		boolean flag = false;
		while (loop_count < 15) {
			int space_temp = 0;
			int space_temp2 = 0;
			//according to the operations in here,it leaves spaces.
			if (Player_1.size() == Player_2.size()) {
				space_temp = Player_1.size() + 4;
				space_temp2 = Player_2.size() + 4;
			} else if (Player_1.size() > Player_2.size()) {
				space_temp = 4;
				space_temp2 = 2 * (Player_1.size() - Player_2.size()) + 4;
			} else if (Player_1.size() < Player_2.size()) {
				space_temp = 2 * (Player_2.size() - Player_1.size()) + 4;
				space_temp2 = 4;
			}
			flag = false;
			//adding 3 random number to queue.
			for (int i = 0; i < 3; i++) {
				int rnd = (int) (Math.random() * 6) + 1;
				Player_1.enqueue(rnd);
			}
			for (int i = 0; i < 3; i++) {
				int rnd = (int) (Math.random() * 6) + 1;
				Player_2.enqueue(rnd);
			}
			System.out.println("Turn: " + (loop_count + 1));
			System.out.print("Player 1: ");
			int player1_size = Player_1.size();
			for (int i = 0; i < player1_size; i++) {
				System.out.print(Player_1.peek() + " ");
				Player_1.enqueue(Player_1.dequeue());
			}
			for (int i = 0; i < space_temp; i++) {
				System.out.print(" ");
			}
			int count3 = 0;
			//If the same four numbers arrive in player 1's queue, it deletes them.
			for (int j = 1; j <= 6; j++) {
				int count = 0;
				player1_size = Player_1.size();
				for (int i = 0; i < player1_size; i++) {
					if (j == (int) Player_1.peek()) {
						count++;
					}
					Player_1.enqueue(Player_1.dequeue());
				}
				if (count >= 4) {
					flag = true;
					int count2 = 0;
					player1_size = Player_1.size();
					for (int k = 0; k < player1_size; k++) {
						if (j == (int) Player_1.peek() && count2 < 4) {
							Player_1.dequeue();
							count2++;
						} else {
							Player_1.enqueue(Player_1.dequeue());
						}
					}
					space_temp += 8;
					player1_score += 20;
				}
			}
			//if sequential numbers come in player1's queue, it deletes them.
			count3 = 0;
			for (int j = 1; j <= 6; j++) {
				boolean flag2 = false;
				player1_size = Player_1.size();
				for (int i = 0; i < player1_size; i++) {
					if (j == (int) Player_1.peek() && flag2 == false) {
						count3++;
						flag2 = true;
					}
					Player_1.enqueue(Player_1.dequeue());
				}
				if (count3 == 6) {
					flag = true;
					for (int i = 1; i <= 6; i++) {
						boolean flag3 = false;
						player1_size = Player_1.size();
						for (int k = 0; k < player1_size; k++) {
							if (i == (int) Player_1.peek() && flag3 == false) {
								Player_1.dequeue();
								flag3 = true;
							}
							if (Player_1.size() == 0) {
								break;
							}
							Player_1.enqueue(Player_1.dequeue());
						}
					}
					space_temp += 12;
					player1_score += 10;
					count3 = 0;
				}
			}
			System.out.println("score: " + player1_score);
			System.out.print("Player 2: ");
			int player2_size = Player_2.size();
			for (int i = 0; i < player2_size; i++) {
				System.out.print(Player_2.peek() + " ");
				Player_2.enqueue(Player_2.dequeue());
			}
			for (int i = 0; i < space_temp2; i++) {
				System.out.print(" ");
			}
			//If the same four numbers arrive in player 2's queue, it deletes them.
			count3 = 0;
			for (int j = 1; j <= 6; j++) {
				int count = 0;
				player2_size = Player_2.size();
				for (int i = 0; i < player2_size; i++) {
					if (j == (int) Player_2.peek()) {
						count++;
					}
					Player_2.enqueue(Player_2.dequeue());
				}
				if (count >= 4) {
					flag = true;
					int count2 = 0;
					player2_size = Player_2.size();
					for (int k = 0; k < player2_size; k++) {
						if (j == (int) Player_2.peek() && count2 < 4) {
							Player_2.dequeue();
							count2++;
						} else {
							Player_2.enqueue(Player_2.dequeue());
						}
					}
					space_temp2 += 8;
					player2_score += 20;
				}
			}
			//if sequential numbers come in player1's queue, it deletes them.
			count3 = 0;
			for (int j = 1; j <= 6; j++) {
				boolean flag2 = false;
				player2_size = Player_2.size();
				for (int i = 0; i < player2_size; i++) {
					if (j == (int) Player_2.peek() && flag2 == false) {
						count3++;
						flag2 = true;
					}
					Player_2.enqueue(Player_2.dequeue());
				}
				if (count3 == 6) {
					flag = true;
					for (int i = 1; i <= 6; i++) {
						boolean flag3 = false;
						player2_size = Player_2.size();
						for (int k = 0; k < player2_size; k++) {
							if (i == (int) Player_2.peek() && flag3 == false) {
								Player_2.dequeue();
								flag3 = true;
							}
							if (Player_2.size() == 0) {
								break;
							}
							Player_2.enqueue(Player_2.dequeue());
						}
					}
					space_temp2 += 12;
					player2_score += 10;
					count3 = 0;
				}
			}
			System.out.println("score: " + player2_score);
			System.out.println("\n");
			if (flag == true) {
				System.out.print("Player 1: ");
				player1_size = Player_1.size();
				for (int i = 0; i < player1_size; i++) {
					System.out.print(Player_1.peek() + " ");
					Player_1.enqueue(Player_1.dequeue());
				}
				for (int i = 0; i < space_temp; i++) {
					System.out.print(" ");
				}
				System.out.println("score: " + player1_score);
				System.out.print("Player 2: ");
				player2_size = Player_2.size();
				for (int i = 0; i < player2_size; i++) {
					System.out.print(Player_2.peek() + " ");
					Player_2.enqueue(Player_2.dequeue());
				}
				for (int i = 0; i < space_temp2; i++) {
					System.out.print(" ");
				}
				System.out.println("score: " + player2_score);
				System.out.println("\n");
			}
			//if 'loop_count' variable arrives 15,the game finishes. 
			if ((loop_count + 1) == 15) {
				System.out.println("\nGame is over.\n");
				if (player1_score > player2_score)
					System.out.println("The winner is player 1.");
				else if (player1_score < player2_score)
					System.out.println("The winner is player 2.");
				else
					System.out.println("The game drew.");
			}
			loop_count++;
		}
	}
}
