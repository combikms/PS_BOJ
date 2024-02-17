import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;
import java.io.IOException;

public class Main {
    private static int N;
    private static int M;
    private static Queue<int[]> queue = new LinkedList<>();
    private static int[] dx = { 1, -1, 0, 0 };
    private static int[] dy = { 0, 0, 1, -1 };
    private static int[][] board;
    private static boolean[][][] visited; // 마지막 차원: 부수기 쓴 경우(0) or 안 쓴 경우(1)

    public static int BFS() {
        visited[0][0][0] = true;
        queue.offer(new int[] { 0, 0, 1, 0 }); // x, y, dist, isBroken

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == N - 1 && cur[1] == M - 1) {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int isBroken = cur[3] + board[nx][ny];

                    if (isBroken <= 1 && !visited[nx][ny][isBroken]) {
                        visited[nx][ny][isBroken] = true;
                        queue.offer(new int[] { nx, ny, cur[2] + 1, isBroken });
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        board = new int[N][M];
        visited = new boolean[N][M][2];

        String S;
        for (int i = 0; i < N; i++) {
            S = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = S.charAt(j) - '0';
            }
        }
        bw.write(BFS() + "");

        bw.close();
        br.close();
    }
}