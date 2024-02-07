import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Main {
    private static int[][] board;
    private static boolean[][] visited;
    private static int count = 0;

    public static void visit(int x, int y) {
        visited[x][y] = true;
        count++;
    }

    public static int DFS(int[][] board, int i, int j) {
        visit(i, j);
        if (i < board.length - 1 && board[i + 1][j] == 1 && visited[i + 1][j] == false) {
            DFS(board, i + 1, j);
        }
        if (i > 0 && board[i - 1][j] == 1 && visited[i - 1][j] == false) {
            DFS(board, i - 1, j);
        }
        if (j < board[0].length - 1 && board[i][j + 1] == 1 && visited[i][j + 1] == false) {
            DFS(board, i, j + 1);
        }
        if (j > 0 && board[i][j - 1] == 1 && visited[i][j - 1] == false) {
            DFS(board, i, j - 1);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;
        ArrayList<Integer> ans = new ArrayList<>();
        int M, N, K;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            board = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                input = br.readLine().split(" ");
                board[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (visited[j][k] == false && board[j][k] == 1) {
                        ans.add(DFS(board, j, k));
                        count = 0;
                    }
                }
            }

            bw.write(ans.size() + "\n");
            ans.removeAll(ans);
        }
        bw.flush();

        bw.close();
        br.close();
    }
}