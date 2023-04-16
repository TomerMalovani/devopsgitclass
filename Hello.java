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
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}
}