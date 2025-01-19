package boardGame;
import java.util.Set;
import java.util.HashSet;

/*
 * Tic Tac Toe class which checks for the winner in a 4x4 game.
 */
public class TicTacToe {

	private final char[][] gameBoard;
	private final int size;
	private boolean isBoardValid;
	
	public TicTacToe(char[][] gameBoard) {
		this.gameBoard = gameBoard;
		this.size = gameBoard.length;
		this.isBoardValid = validateBoard(gameBoard) && validateMoves(gameBoard);
	}
	
	/**
	 * Validates the board is a 4x4.
	 * Uncomment the System.out lines to see the message on terminal
	 * @param gameBoard
	 * @throws IllegalArgumentException if the game board is not a 4x4
	 */
	private boolean validateBoard(char[][] gameBoard) {
		int boardSize = 4;
		if (gameBoard.length != boardSize  || gameBoard[0].length != boardSize) {
			// System.out.println("Board must be 4x4"); 
			return false;
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (gameBoard[i][j] != 'X' && gameBoard[i][j] != 'O' && gameBoard[i][j] != ' ') {
					// System.out.println("Board can only contain 'X', 'O', ' '");
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Validates there's a balanced amount of X's and O's
	 * @param gameBoard
	 * @throw IllegalArgumentException
	 */
	private boolean validateMoves(char[][] gameBoard) {
		int xCount = 0;
		int oCount = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (gameBoard[i][j] == 'X') {
					xCount++;
				} else if (gameBoard[i][j] == 'O') {
					oCount++;
				}
			}
		}
			
		if (xCount < oCount || xCount > oCount + 1) {
			System.out.println("Unbalanced number of moves X: "+ xCount + ", O: " + oCount);
			return false;
		}
		return true;
	}
	
	/**
	 * Checks for winner.
	 * Winning conditions: 1. Horizontal, 2. Vertical, 3. Diagonal, 4. All four corners, 5. 2x2 box.
	 * This method determines if there's a winner based on the game's rules.
	 * @return The winner if there's one, A tie if no clear winner, or "None" if there's no winner.
	 */
	public String checkWinner() {
		
		// Check if board is valid. e.g size, too many moves by the same player.
		if (!isBoardValid) {
			return "Invalid game board";
		}
		
		Set<String> xWins = new HashSet<>();
		Set<String> oWins = new HashSet<>();
		
		checkRowsAndColumns(xWins, oWins);
		checkDiagonals(xWins, oWins);
		checkCorners(xWins, oWins);
		check2x2Box(xWins, oWins);
		
		// Check if there are multiple winning entries
		if (!xWins.isEmpty() && !oWins.isEmpty()) {
			return "Multiple winning entries. It's a Draw";
		}
				
		if (!xWins.isEmpty()) {
			return "X Wins";
		}	

		if (!oWins.isEmpty()) {
			return "O Wins";
		}
	
		return "Game is OnGoing";
	}
	
	/*
	 * Checks for horizontal and vertical wins.
	 */
	private void checkRowsAndColumns(Set<String> xWins, Set<String> oWins) {
		for (int i = 0; i < size; i++) {
			char rowPlayer = gameBoard[i][0];
			char colPlayer = gameBoard[0][i];
			boolean horizontalWin = true;
			boolean verticalWin = true;
	
			// Horizontal check
			if (rowPlayer != ' ') {
				for (int j = 1; j < size; j++) {
					if (gameBoard[i][j] != rowPlayer) {
						horizontalWin = false;
						break;
					}
				}
				if (horizontalWin) {
					if (rowPlayer == 'X') {
						xWins.add("Row " + i);
					} else {
						oWins.add("Row " + i);
					}
				}
			}
			
			// Vertical check
			if (colPlayer != ' ') {
				for (int j = 1; j < size; j++) {
					if (gameBoard[j][i] != colPlayer) {
						verticalWin = false;
						break;
					}
				}
				if (verticalWin) {
					if (colPlayer == 'X') {
						xWins.add("Column " + i);
					} else {
						oWins.add("Column " + i);
					}
				}
			}
		}
	}
	
	/**
	 * Checks for diagonal wins (top left to bottom right and top right to bottom left).
	 */
	private void checkDiagonals(Set<String> xWins, Set<String> oWins) {
		// Check top left to bottom right diagonally
		char leftSidePlayer = gameBoard[0][0]; // Check first element on left side
		if (leftSidePlayer != ' ') {
			boolean leftDiagonalWin = true;
			
			for (int i = 1; i < size; i++) {
				if (leftSidePlayer != (gameBoard[i][i])) {
					leftDiagonalWin = false;
					break;
				}
			}
			
			if (leftDiagonalWin) {
				if (leftSidePlayer == 'X') {
					xWins.add("leftSide wins");
				} else {
					oWins.add("leftSide wins");
				}
			}
		}
		
		// Check top right to bottom left diagonally
		char rightSidePlayer = gameBoard[0][size -1]; // Check first element on right side
		if (rightSidePlayer != ' ') {
			boolean rightDiagonalWin = true;
			for (int i = 1; i < size; i++) {
				if (rightSidePlayer != (gameBoard[i][size - i - 1])) {
					rightDiagonalWin = false;
					break;
				}
			}
			
			if (rightDiagonalWin) {
				if (rightSidePlayer == 'X') {
					xWins.add("rightSide wins");
				} else {
					oWins.add("rightSide wins");
				}
			}
		}
	}
	
	/**
	 * Checks if the player won by taking all four corners.
	 */
	private void checkCorners(Set<String> xWins, Set<String> oWins) {
		char topRight = gameBoard[0][size - 1];
		char topLeft = gameBoard[0][0];
		char bottomRight = gameBoard[size - 1][size - 1];
		char bottomLeft = gameBoard[size - 1][0];
		
		if (topLeft != ' ' && topLeft == topRight && topLeft == bottomLeft && topLeft == bottomRight) {
			if (topLeft == 'X') {
				xWins.add("All Four Corners");
			} else {
				oWins.add("All Four Corners");
			}
		}
	}
	
	/**
	 * Checks for a 2x2 box filled by the same player.
	 */
	private void check2x2Box(Set<String> xWins, Set<String> oWins) {
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1; j++) {
				char player = gameBoard[i][j];
				if (player != ' ' && player == (gameBoard[i][j + 1]) && 
					player == gameBoard[i + 1][j] && 
					player == gameBoard[i + 1][j + 1]) {
					
					if (player == 'X') {
						xWins.add("2x2 box Win");
					} else {
						oWins.add("2x2 box win");
					}
				}
			}
		}
	}
	
	/**
	 * Checks if there are any moves left in the game.
	 * @return true if there are remaining moves, or false otherwise.
	 */
	public boolean anyMovesLeft() {
		// Return true if less than 16 moves have been made (4x4)
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (gameBoard[i][j] == ' ') {
					return true;
				}
			}
		}
		return false;
	}	
	
	/**
	 * Checks if the game is over.
	 * @return true if the game is over, false otherwise.
	 */
	public boolean isGameOver() {
		return !anyMovesLeft() || checkWinner() != "Game is OnGoing";
	}
	
	/**
	 * Displays the game board
	 */
	public void printBoard() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(gameBoard[i][j] == ' '? " - " : gameBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
