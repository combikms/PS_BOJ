import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class Main {
    private static int N = 0;
    private static int[][] board;
    private static Queue<Integer> queueX = new LinkedList<>();
    private static Queue<Integer> queueY = new LinkedList<>();

    public static void BFS(int i, int j) {
        board[i][j] = 1;
        queueX.offer(i);
        queueY.offer(j);
        while (!queueY.isEmpty() && !queueX.isEmpty()) {
            int X = queueX.poll();
            int Y = queueY.poll();
            if (X > 1 && Y < N - 1) {
                if (board[X - 2][Y + 1] == 0) {
                    board[X - 2][Y + 1] = board[X][Y] + 1;
                    queueX.offer(X - 2);
                    queueY.offer(Y + 1);
                }
            }
            if (X > 0 && Y < N - 2) {
                if (board[X - 1][Y + 2] == 0) {
                    board[X - 1][Y + 2] = board[X][Y] + 1;
                    queueX.offer(X - 1);
                    queueY.offer(Y + 2);
                }
            }
            if (X > 1 && Y > 0) {
                if (board[X - 2][Y - 1] == 0) {
                    board[X - 2][Y - 1] = board[X][Y] + 1;
                    queueX.offer(X - 2);
                    queueY.offer(Y - 1);
                }
            }
            if (X > 0 && Y > 1) {
                if (board[X - 1][Y - 2] == 0) {
                    board[X - 1][Y - 2] = board[X][Y] + 1;
                    queueX.offer(X - 1);
                    queueY.offer(Y - 2);
                }
            }
            if (X < N - 2 && Y < N - 1) {
                if (board[X + 2][Y + 1] == 0) {
                    board[X + 2][Y + 1] = board[X][Y] + 1;
                    queueX.offer(X + 2);
                    queueY.offer(Y + 1);
                }
            }
            if (X < N - 1 && Y < N - 2) {
                if (board[X + 1][Y + 2] == 0) {
                    board[X + 1][Y + 2] = board[X][Y] + 1;
                    queueX.offer(X + 1);
                    queueY.offer(Y + 2);
                }
            }
            if (X < N - 2 && Y > 0) {
                if (board[X + 2][Y - 1] == 0) {
                    board[X + 2][Y - 1] = board[X][Y] + 1;
                    queueX.offer(X + 2);
                    queueY.offer(Y - 1);
                }
            }
            if (X < N - 1 && Y > 1) {
                if (board[X + 1][Y - 2] == 0) {
                    board[X + 1][Y - 2] = board[X][Y] + 1;
                    queueX.offer(X + 1);
                    queueY.offer(Y - 2);
                }
            }
        }
        // 먼가 디러운 느낌..
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        String[] input;
        int startX, startY, endX, endY;
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];

            input = br.readLine().split(" ");
            startX = Integer.parseInt(input[0]);
            startY = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            endX = Integer.parseInt(input[0]);
            endY = Integer.parseInt(input[1]);

            BFS(startX, startY);
            bw.write(board[endX][endY] - 1 + "\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}