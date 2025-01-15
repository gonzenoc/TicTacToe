package boardGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicTacToeTests {

	private TicTacToe game;
	
	@Test
	public void testValidateBoard_ValidSize() {
		char[][] gameBoard = {
				{'X', 'O', 'X', 'O'},
				{'O', 'X', 'O', 'O'},
				{'O', 'X', 'X', 'O'},
				{'X', 'X', 'O', 'X'}
		};
		game = new TicTacToe(gameBoard);
		String result = game.checkWinner();
		assertFalse("Board is valid", result.equals("Invalid game board"));
	}
	
	@Test
	public void testValidateBoard_InvalidSize() {
		char[][] gameBoard = {
				{'X', 'O', 'X', 'O'},
				{'O', 'X', 'O', 'O'},
				{'O', 'X', 'X', 'O'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'O'}
		};
		
		game = new TicTacToe(gameBoard);
		String result = game.checkWinner();
		assertTrue("Invalid game board", result.equals("Invalid game board"));
	}
	
	@Test
	public void testInvalidCharactersOnBoard() {
		char[][] gameBoard = {
				{'A', 'O', 'X', 'O'},
				{'O', 'X', 'O', 'O'},
				{'O', 'X', 'X', 'O'},
				{'X', 'X', 'O', 'X'}
		};
		
		game = new TicTacToe(gameBoard);
		String result = game.checkWinner();
		assertTrue("Invalid characters", result.contains("Invalid game board"));
	}

	@Test
	public void testLeftDiagonalWin_X() {
		char[][] gameBoard = {
				{'X', 'O', 'X', 'O'},
				{'O', 'X', 'X', 'X'},
				{'O', 'O', 'X', 'O'},
				{'O', 'X', 'O', 'X'}
		};
		game = new TicTacToe(gameBoard);
		assertEquals("X Wins", game.checkWinner());
	}

	@Test
	public void testRighDiagonalWin_O() {
		char[][] gameBoard = {
				{'X', 'X', 'X', 'O'},
				{'O', 'X', 'O', 'X'},
				{'X', 'O', 'O', 'O'},
				{'O', 'X', 'O', 'X'}
		};
		game = new TicTacToe(gameBoard);
		assertEquals("O Wins", game.checkWinner());
	}

	@Test
	public void testHorizontalWin_X() {
		char[][] gameBoard = {
				{'X', 'X', 'X', 'X'},
				{'O', 'O', 'O', 'X'},
				{'O', 'X', 'O', 'X'},
				{'O', 'X', 'O', 'O'}
		};
		game = new TicTacToe(gameBoard);
		assertEquals("X Wins", game.checkWinner());
	}

	@Test
	public void testHorizontalWin_O() {
		char[][] gameBoard = {
				{'X', 'O', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'O', 'O', 'O', 'O'}
		};
		game = new TicTacToe(gameBoard);
		assertEquals("O Wins", game.checkWinner());
	}

	@Test
	public void testVerticalWin_X() {
		char[][] gameBoard = {
				{'X', 'O', 'X', 'X'},
				{'O', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'O', 'O', 'O', 'X'}
		};
		game = new TicTacToe(gameBoard);
		assertEquals("X Wins", game.checkWinner());
	}
	@Test
	public void testVerticalWin_O() {
		char[][] gameBoard = {
				{'O', 'O', 'X', 'O'},
				{'X', 'X', 'X', 'O'},
				{'X', 'O', 'X', 'O'},
				{'X', 'X', 'O', 'O'}
		};
		game = new TicTacToe(gameBoard);
		assertEquals("O Wins", game.checkWinner());
	}

	@Test
	public void test2x2BoxWin_X() {
		char[][] gameBoard = {
				{'X', 'O', 'O', 'O'},
				{'O', 'O', 'X', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'X', 'O', 'O'}
		};
		game = new TicTacToe(gameBoard);
		assertEquals("X Wins", game.checkWinner());
	}

	@Test
	public void test2x2BoxWin_O() {
		char[][] gameBoard = {
				{'X', 'O', 'X', 'O'},
				{'O', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'O'},
				{'X', 'X', 'O', 'O'}
		};
		game = new TicTacToe(gameBoard);
		assertEquals("O Wins", game.checkWinner());
	}

	@Test
	public void testAllFourCornersWin_X() {
		char[][] gameBoard = {
				{'X', 'O', 'O', 'X'},
				{'O', 'X', 'X', 'O'},
				{'X', 'O', 'O', 'O'},
				{'X', 'O', 'X', 'X'}
		};
		game = new TicTacToe(gameBoard);
		assertEquals("X Wins", game.checkWinner());
	}

	@Test
	public void testAllFourCornersWin_O() {
		char[][] gameBoard = {
				{'O', 'O', 'X', 'O'},
				{'O', 'X', 'X', 'O'},
				{'X', 'X', 'O', 'X'},
				{'O', 'X', 'X', 'O'}
		};
		game = new TicTacToe(gameBoard);
		assertEquals("O Wins", game.checkWinner());
	}

	@Test
	public void testAnyMovesLeftTrue() {
		char[][] gameBoard = {
				{'X', 'O', 'X', 'O'},
				{'X', 'O', ' ', 'X'},
				{'O', 'X', 'O', ' '},
				{'X', 'O', 'X', 'O'}
		};
		game = new TicTacToe(gameBoard);
		assertTrue("There are moves left", game.anyMovesLeft());
	}

	@Test
	public void testAnyMovesLeftFalse() {
		char[][] gameBoard = {
				{'X', 'X', 'X', 'O'},
				{'O', 'O', 'X', 'X'},
				{'X', 'X', 'O', 'O'},
				{'O', 'X', 'O', 'O'}
		};
		game = new TicTacToe(gameBoard);
		assertFalse("There are no moves left", game.anyMovesLeft());
	}

	@Test
	public void testIsGameOverFalse() {
		char[][] gameBoard = {
				{'X', 'O', 'X', 'O'},
				{'X', 'O', ' ', 'X'},
				{'O', 'X', 'O', ' '},
				{'X', 'O', 'X', 'O'}
		};
		game = new TicTacToe(gameBoard);
		assertFalse("The game is not over", game.isGameOver());
	}

	@Test
	public void testIsGameOverTrue() {
		char[][] gameBoard = {
				{'X', 'O', 'X', 'X'},
				{'O', 'O', 'X', 'X'},
				{'O', 'X', 'O', 'O'},
				{'X', 'O', 'X', 'O'}
		};
		game = new TicTacToe(gameBoard);
		assertTrue("The game is over", game.isGameOver());
	}

}
