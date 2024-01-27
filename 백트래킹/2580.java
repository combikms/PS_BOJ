import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean backtrack(int[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }
        if (col == 9) {
            return backtrack(board, row + 1, 0);
        }
        if (board[row][col] != 0) {
            return backtrack(board, row, col + 1);
        }
        for (int number = 1; number <= 9; number++) {
            if (isValid(board, row, col, number)) {
                board[row][col] = number;
                if (backtrack(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isValid(int[][] board, int row, int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == number) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == number) {
                return false;
            }
        }
        for (int i = 3 * (row / 3); i < 3 * (row / 3) + 3; i++) {
            for (int j = 3 * (col / 3); j < 3 * (col / 3) + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[9][9];
        String[] input;

        for (int i = 0; i < 9; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        backtrack(board, 0, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(board[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}