import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[][] board = new int[N + 1][M + 1];
        int[][] b_Board = new int[N + 1][M + 1]; // b == 0
        int[][] w_Board = new int[N + 1][M + 1]; // w == 1

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                b_Board[i][j] = (i + j) % 2 == 0 ? 0 : 1;
                w_Board[i][j] = (i + j) % 2 == 0 ? 1 : 0;
            }
        }

        String S;
        for (int i = 1; i <= N; i++) {
            S = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = S.charAt(j - 1) == 'W' ? 1 : 0;
            }
        }

        // 대상과 다른 블록들은 1, 나머진 0으로 업뎃
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                w_Board[i][j] = w_Board[i][j] != board[i][j] ? 1 : 0;
                b_Board[i][j] = b_Board[i][j] != board[i][j] ? 1 : 0;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                w_Board[i][j] = w_Board[i][j - 1] + w_Board[i - 1][j] - w_Board[i - 1][j - 1] + w_Board[i][j];
                b_Board[i][j] = b_Board[i][j - 1] + b_Board[i - 1][j] - b_Board[i - 1][j - 1] + b_Board[i][j];
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int w = w_Board[i][j] - w_Board[i][j - K] - w_Board[i - K][j] + w_Board[i - K][j - K];
                int b = b_Board[i][j] - b_Board[i][j - K] - b_Board[i - K][j] + b_Board[i - K][j - K];
                ans = Math.min(ans, Math.min(w, b));
            }
        }
        bw.write(ans + "");
        bw.flush();

        bw.close();
        br.close();
    }
} // O(5*N*M)