import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
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
        if (j < board.length - 1 && board[i][j + 1] == 1 && visited[i][j + 1] == false) {
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

        String S;
        ArrayList<Integer> ans = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            S = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = S.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false && board[i][j] == 1) {
                    ans.add(DFS(board, i, j));
                    count = 0;
                }
            }
        }

        Collections.sort(ans);
        bw.write(ans.size() + "\n");
        for (int i = 0; i < ans.size(); i++) {
            bw.write(ans.get(i) + "\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}