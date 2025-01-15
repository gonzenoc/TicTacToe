package boardGame;

/**
 * Main class to check winner of a tic tac toe game
 * Simply pass a 4x4 board with valid input e.g "X or O".
 * Conditions to win can be either: 
 * 1. Horizontal, 2. Vertical, 3. Diagonal, 4. All four corners, 5. 2x2 box
 * @author enocgonzalez
 */
public class StartGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Diagonal
		char[][] boardDiagonal = {
				{'X', 'O', 'X', 'O'},
				{'O', 'X', 'X', 'X'},
				{'O', 'O', 'X', 'O'},
				{'O', 'X', 'O', 'X'}
		};
		
		TicTacToe gameOne = new TicTacToe(boardDiagonal);
		gameOne.printBoard();			
		String winner = gameOne.checkWinner();
		System.out.println("\n" + winner);
		
		System.out.println("================================");
		
		// Horizontal
		char[][] boardHorizontal = {
				{'X', 'X', 'X', 'O'},
				{'O', 'O', 'O', 'O'},
				{'O', 'X', 'X', 'X'},
				{'O', 'X', 'O', 'X'}
		};
		
		TicTacToe gameTwo = new TicTacToe(boardHorizontal);
		gameTwo.printBoard();
		
		winner = gameTwo.checkWinner();
		System.out.println("\n" + winner);
		
		System.out.println("================================");
		// Vertical
		char[][] boardVertical = {
				{'O', 'O', 'X', 'O'},
				{'X', 'X', 'X', 'O'},
				{'X', 'O', 'X', 'O'},
				{'X', 'X', 'O', 'O'}
		};
		
		TicTacToe gameThree = new TicTacToe(boardVertical);
		gameThree.printBoard();
		
		winner = gameThree.checkWinner();
		System.out.println("\n" + winner);
		System.out.println("================================");
		
		// 2x2 Box
		char[][] boardBoxWin = {
				{'X', 'O', 'O', 'O'},
				{'O', 'O', 'X', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'X', 'O', 'O'}
		};
		
		TicTacToe gameFour = new TicTacToe(boardBoxWin);
		gameFour.printBoard();
		
		winner = gameFour.checkWinner();
		System.out.println("\n" + winner);
		
		System.out.println("================================");
		
		// 2x2 Box
		char[][] allFourCorners = {
				{'X', 'O', 'O', 'X'},
				{'O', 'O', 'X', 'X'},
				{'O', 'X', 'O', 'O'},
				{'X', 'X', 'O', 'X'}
		};
		
		TicTacToe gameFive = new TicTacToe(allFourCorners);
		gameFive.printBoard();
		
		winner = gameFive.checkWinner();
		System.out.println("\n" + winner);
	}

}
