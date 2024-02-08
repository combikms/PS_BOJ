import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N = 0;
    private static int M = 0;
    private static int[][] board;
    private static int[][] visited;
    private static int count = 0;
    private static Queue<Integer> queueX = new LinkedList<>();
    private static Queue<Integer> queueY = new LinkedList<>();

    public static void visit(int x, int y) throws IOException {
        visited[x][y]++;
        count++;
        if (x == N - 1 && y == M - 1) {
            bw.write(count + "");
            bw.flush();
        }
    }

    public static int DFS(int[][] board, int i, int j) throws IOException {
        visit(i, j);
        if (i < board.length - 1 && board[i + 1][j] == 1 && visited[i + 1][j] == 0) {
            DFS(board, i + 1, j);
        }
        if (i > 0 && board[i - 1][j] == 1 && visited[i - 1][j] == 0) {
            DFS(board, i - 1, j);
        }
        if (j < board[0].length - 1 && board[i][j + 1] == 1 && visited[i][j + 1] == 0) {
            DFS(board, i, j + 1);
        }
        if (j > 0 && board[i][j - 1] == 1 && visited[i][j - 1] == 0) {
            DFS(board, i, j - 1);
        }
        return count;
    }

    public static int BFS(int[][] board, int i, int j) throws IOException {
        visited[i][j] = 1;
        queueX.offer(i);
        queueY.offer(j);
        while (!queueX.isEmpty() && !queueY.isEmpty()) {
            int X = queueX.poll();
            int Y = queueY.poll();
            if (X < board.length - 1 && board[X + 1][Y] == 1 && visited[X + 1][Y] == 0) {
                visited[X + 1][Y] = visited[X][Y] + 1;
                queueX.offer(X + 1);
                queueY.offer(Y);
            }
            if (Y < board[0].length - 1 && board[X][Y + 1] == 1 && visited[X][Y + 1] == 0) {
                visited[X][Y + 1] = visited[X][Y] + 1;
                queueX.offer(X);
                queueY.offer(Y + 1);
            }
            if (X > 0 && board[X - 1][Y] == 1 && visited[X - 1][Y] == 0) {
                visited[X - 1][Y] = visited[X][Y] + 1;
                queueX.offer(X - 1);
                queueY.offer(Y);
            }
            if (Y > 0 && board[X][Y - 1] == 1 && visited[X][Y - 1] == 0) {
                visited[X][Y - 1] = visited[X][Y] + 1;
                queueX.offer(X);
                queueY.offer(Y - 1);
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        board = new int[N][M];
        visited = new int[N][M];

        String S;
        for (int i = 0; i < N; i++) {
            S = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = S.charAt(j) - '0';
            }
        }

        BFS(board, 0, 0);
        bw.write(visited[N - 1][M - 1] + "");
        bw.flush();

        bw.close();
        br.close();
    }
}