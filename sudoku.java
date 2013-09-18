import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 TASK: sudoku
 LANG: JAVA
 */
public class sudoku {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(
				System.in));
		int n = Integer.parseInt(buff.readLine());
		int[][] arr = new int[9 * (n + 1)][9];
		String[] row;

		for (int i = 0; i < arr.length; i++) {
			row = buff.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(row[j]);
			}
		}

		for (int i = 1; i <= n; i++) {
			if (is_same(i, arr))
				System.out.println(i);
		}
		System.out.println("END");

	}

	public static boolean is_same(int m, int[][] arr) {
		int[] sameR = new int[9];
		int[] sameC = new int[9];
		int sumR = 0;
		int sumC = 0;
		int row = 0;
		for (int i = (m * 9); i < (m * 9) + 9; i++) {
			row = (m * 9);
			for (int j = 0; j < 9; j++) {
				if (arr[i][j] == arr[i % 9][j] || arr[i % 9][j] == 0) {
					sumR += arr[i][j];
					sumC += arr[row + j][i % 9];
				}
			}
			if (sumR != 45 || sumC != 45)
				return false;
			sumR = 0;
			sumC = 0;
		}
		return true;
	}

}
