package supreeth;

import java.util.HashSet;
import java.util.Set;

public class SokdukuChecker {
	
	public static boolean notInRow(char[][] board, int row)
	{
		// Set to store characters .
		Set<Character> st = new HashSet<Character>();

		for (int i = 0; i < 9; i++)
		{

			// If already encountered before, return false
			if (st.contains(board[row][i]))
			{
				return false;
			}

			// If it is not an empty cell, insert value
			// at the current cell in the set
			if (!(board[row][i]==('.')))
			{
				st.add(board[row][i]);
			}
		}
		return true;
	}


	// Checks whether there is any duplicate
	// in current column or not.
	public static boolean notInCol(char[][] board, int col)
	{
		Set<Character> st = new HashSet<Character>();

		for (int i = 0; i < 9; i++)
		{

			// If already encountered before, return false
			if (st.contains(board[i][col]))
			{
				return false;
			}

			// If it is not an empty cell,
			// insert value at the current cell in the set
			if (!(board[i][col]=='.'))
			{
				st.add(board[i][col]);
			}
		}
		return true;
	}

	// Checks whether there is any duplicate
	// in current 3x3 box or not.
	public static boolean notInBox(char[][] board, int startRow, int startCol)
	{
		Set<Character> st = new HashSet<Character>();

		for (int row = 0; row < 3; row++)
		{
			for (int col = 0; col < 3; col++)
			{
				char curr = board[row + startRow][col + startCol];

				// If already encountered before, return false
				if (st.contains(curr))
				{
					return false;
				}

				// If it is not an empty cell,
				// insert value at current cell in set
				if (curr != '.')
				{
					st.add(curr);
				}
			}
		}
		return true;
	}

	// Checks whether current row and current column and
	// current 3x3 box is valid or not
	public static boolean isValid(char[][] board, int row, int col)
	{
		return notInRow(board, row) && notInCol(board, col) && notInBox(board, row - row % 3, col - col % 3);
	}

	public static boolean isValidConfig(char[][] board, int n)
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{

				// If current row or current column or
				// current 3x3 box is not valid, return false
				if (!isValid(board, i, j))
				{
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board =
			 { { '.', '.', '.', '.', '.', '.', '.', 6, '.' },
		                { '.', '.', 7, 3, '.', '.', 9, '.', '.' }, { '.', '.', 8, 9, '.', '.', '.', '.', '.' },
		                { '.', 7, 1, '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', 8 },
		                { 8, '.', '.', '.', 5, '.', 6, '.', 4 }, { '.', 1, '.', 2, '.', '.', '.', 9, '.' },
		                { 2, '.', '.', '.', '.', 4, '.', '.', '.' }, { '.', 6, 9, '.', '.', '.', '.', 7, '.' } };

			System.out.print((isValidConfig(board, 9) ? "YES\n" : "NO\n"));

	}

}
