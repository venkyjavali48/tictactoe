package com.tictac.application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeApplication {
	public static String[] board; 
	public static String turn; 

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		board = new String[9]; 
		turn = "X"; 
		String winner = null; 

		for (int a = 0; a < 9; a++) { 
			board[a] = String.valueOf(a + 1); 
		} 
		
		//Initialize board with 3X3 matrix of numbers from 1 to 9
		System.out.println("Game Board Creation..."); 
		BoardCreation.createBoard(board); 

		System.out.println("Board Created.\r\n" + 
			"The game will start with player X"); 

		while (winner == null) { 
			int numInput = 0; 
			
		
		// numInput will take input from user like from 1 to 9. 
		// If it is not in range from 1 to 9. 
		// then it will show you an error "Invalid input." 
			try { 
				numInput = in.nextInt(); 
				if (!(numInput > 0 && numInput <= 9)) { 
					System.out.println("Invalid input; re-enter slot number:"); 
					continue; 
				} 
			} 
			catch (InputMismatchException e) { 
				System.out.println( 
					"Invalid input; Only Numbers allowed"); 
				System.exit(0);
			} 
			
			// This game has two player x and O. 
			// Here is the logic to decide the turn. 
			if (board[numInput - 1].equals( 
					String.valueOf(numInput))) { 
				board[numInput - 1] = turn; 

				if (turn.equals("X")) { 
					turn = "O"; 
				} 
				else { 
					turn = "X"; 
				} 
				
				//Creating board for every turn and finding winner
				BoardCreation.createBoard(board);
				winner = CheckWinner.findWinner(board, turn);
			} 
			else { 
				System.out.println( 
					"Slot already taken; re-enter slot number:"); 
			} 
		} 
		
		// If no one win or lose from both player x and O. 
		// then here is the logic to print "draw". 
		if (winner.equalsIgnoreCase("draw")) { 
			System.out.println( 
				"GAME ENDS WITH A DRAW!"); 
		} 
		
		// For winner to display message. 
		else { 
			System.out.println("PLAYER "+winner+" WON!"); 
		}
	}

}
