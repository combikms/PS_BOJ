import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int solution = 0;

    public static void backtrack(int[][] board, int row) {
        if (row == N) {
            solution++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 1;
                backtrack(board, row + 1);
                board[row][col] = 0;
            }
        }

    }

    public static boolean isValid(int[][] board, int row, int col) {

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        backtrack(board, 0);

        bw.write(solution + "");

        bw.flush();
        br.close();
        bw.close();
    }
}