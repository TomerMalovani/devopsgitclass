import java.util.Scanner;

public class Hello{
	public static void main(String[] args){
		for (int i = 0; i <= 10; i++) {
			System.out.println("Hello World...."+i);

		}

		//game of checker
		int[][] board = new int[8][8];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						board[i][j] = 1;
					}
				} else {
					if (j % 2 != 0) {
						board[i][j] = 1;
					}
				}
			}
		}

	

		//init pawns
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i == 1) {
					board[i][j] = 2;
				} else if (i == 6) {
					board[i][j] = 3;
				}
			}
		}

		System.out.println("After init pawns");
		
		System.out.println("new");

		//playGame(board);

	}

	//ask user for input
		
		//move pawn
		//check if move is valid
		//if valid, move pawn
		//if not valid, ask user for input again
		//check if game is over
		//if game is over, end game
		//if game is not over, switch player
		//repeat

		public static void movePawn(int[][] board, int player) {
			Scanner input = new Scanner(System.in);
			System.out.println("Player " + player + " enter your move: ");
			String move = input.nextLine();
			String[] moves = move.split(" ");
			int row = Integer.parseInt(moves[0]);
			int col = Integer.parseInt(moves[1]);
			int newRow = Integer.parseInt(moves[2]);
			int newCol = Integer.parseInt(moves[3]);
			if (board[row][col] == player) {
				if (isLegalMove(board, row, col, newRow, newCol, player)) {
					board[newRow][newCol] = player;
					board[row][col] = 0;
				} else {
					System.out.println("Invalid move");
				}
			} else {
				System.out.println("Invalid move");
			}
		}

		public static boolean isGameOver(int[][] board) {
			int player1 = 0;
			int player2 = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == 2) {
						player1++;
					} else if (board[i][j] == 3) {
						player2++;
					}
				}
			}
			if (player1 == 0 || player2 == 0) {
				return true;
			}
			return false;
		}

		public static void printBoard(int[][] board) {
			//print column numbers
			System.out.print(" |");
			for (int i = 0; i < board[0].length; i++) {
				System.out.print( i+" " );
			}
			System.out.println();
			System.out.print(" |");

			for (int i = 0; i < board[0].length; i++) {
				System.out.print("= ");
			}

			System.out.println();

			for (int i = 0; i < board.length; i++) {
				//print row number
				System.out.print(i + "|");
				for (int j = 0; j < board[i].length; j++) {
					//print column number
					// System.out.print("-"+j + "-");
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}

		public static int switchPlayer(int player) {
			if (player == 2) {
				player = 3;
			} else {
				player = 2;
			}
			return player;
		}

		public static void playGame(int[][] board) {
			int player = 2;
			while (!isGameOver(board)) {

				//clear screen
				System.out.flush();

				printBoard(board);
				movePawn(board, player);
				player=switchPlayer(player);
			}
			System.out.println("Game over");
		}

		//check if move is legal 
		//if legal, move pawn
		//if not legal, ask user for input again

		public static boolean isLegalMove(int[][] board, int row, int col, int newRow, int newCol,int player) {
			if (board[row][col] == player) {
				//check if move is diagonal
				if (Math.abs(row - newRow) == Math.abs(col - newCol)) {
					//check if move is forward
					if (player == 2) {
						if (newRow == row+1) {
							return true;
						}
					} else {
						if (newRow == row-1) {
							return true;
						}
					}
				}


			}
			return false;
		}

		
}