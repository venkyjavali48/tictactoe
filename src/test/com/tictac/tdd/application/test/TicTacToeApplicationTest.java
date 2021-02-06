package com.tictac.tdd.application.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.tictac.application.BoardCreation;
import com.tictac.application.CheckWinner;
import com.tictac.application.TicTacToeApplication;

class TicTacToeApplicationTest {

	String[] expected = new String[9];
	
	
	@Before
	public void init() {
		for (int a = 0; a < 9; a++) { 
			expected[a] = String.valueOf(a + 1);
		}
	}
	//TDD Scenarios:
	//1 – Game Board Creation phase:
	@Test
	void test_board_creation() {
		
		String[] board = new String[9];
		for (int a = 0; a < 9; a++) { 
			board[a] = String.valueOf(a + 1);
		}
		assertEquals(expected, BoardCreation.createBoard(board));
	}
	
	//TDD Scenarios:
	//2 – Player X won with a vertical line
	@Test
	void test_player_X_won_vertical_line() {
		
		String player = "X";
		
		expected[0] = "X";
		expected[3] = "X";
		expected[6] = "X";
		expected[4] = "O";
		expected[8] = "O";
		assertEquals("X", CheckWinner.findWinner(expected, player));
	}
	
	//TDD Scenarios:
	//3 – Player O won with a horizontal line
	@Test
	void test_player_O_won_horizontal_line() {
		
		String player = "O";
		
		expected[3] = "O";
		expected[4] = "O";
		expected[5] = "O";
		expected[0] = "X";
		expected[2] = "X";
		expected[6] = "X";
		assertEquals("O", CheckWinner.findWinner(expected, player));
	}
	
	//TDD Scenarios:
	//4 – Player X won with a diagonal line
	@Test
	void test_player_X_won_diagonal_line() {
		
		String player = "O";
		
		expected[3] = "O";
		expected[6] = "O";
		expected[0] = "X";
		expected[4] = "X";
		expected[8] = "X";
		assertEquals("X", CheckWinner.findWinner(expected, player));
	}
	
	//TDD Scenarios:
	//5 – Game ends with a draw
	@Test
	void test_game_ends_with_draw() {
		
		String player = "X";
		
		expected[0] = "X";
		expected[1] = "O";
		expected[2] = "X";
		expected[3] = "O";
		expected[4] = "O";
		expected[5] = "X";
		expected[6] = "X";
		expected[7] = "X";
		expected[8] = "O";
		assertEquals("draw", CheckWinner.findWinner(expected, player));
	}

}
