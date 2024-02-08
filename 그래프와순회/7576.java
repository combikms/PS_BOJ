import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class Main {
    private static int M = 0;
    private static int N = 0;
    private static int[][] board;
    private static Queue<int[]> queue = new LinkedList<>();

    public static int BFS() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    queue.offer(new int[] { i, j, 0 });
                }
            }
        }

        int days = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            days = cur[2];

            if (cur[0] < M - 1) {
                if (board[cur[0] + 1][cur[1]] == 0) {
                    board[cur[0] + 1][cur[1]] = 1;
                    queue.offer(new int[] { cur[0] + 1, cur[1], days + 1 });
                }
            }
            if (cur[0] > 0) {
                if (board[cur[0] - 1][cur[1]] == 0) {
                    board[cur[0] - 1][cur[1]] = 1;
                    queue.offer(new int[] { cur[0] - 1, cur[1], days + 1 });
                }
            }
            if (cur[1] < N - 1) {
                if (board[cur[0]][cur[1] + 1] == 0) {
                    board[cur[0]][cur[1] + 1] = 1;
                    queue.offer(new int[] { cur[0], cur[1] + 1, days + 1 });
                }
            }
            if (cur[1] > 0) {
                if (board[cur[0]][cur[1] - 1] == 0) {
                    board[cur[0]][cur[1] - 1] = 1;
                    queue.offer(new int[] { cur[0], cur[1] - 1, days + 1 });
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    return -1;
                }
            }
        }

        return days;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        board = new int[M][N];

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        bw.write(BFS() + "");
        bw.flush();

        bw.close();
        br.close();
    }
}