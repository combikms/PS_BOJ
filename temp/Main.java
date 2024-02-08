import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class Main {
    // 최단 비용, 텔레포트 위치 순서로 저장
    private static int[][] board = new int[101][2];
    private static Queue<Integer> queue = new LinkedList<>();

    public static void BFS() {
        board[1][0] = 1;
        queue.offer(1);
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (board[cur][1] != 0) {
                if (board[board[cur][1]][0] == 0) {
                    board[board[cur][1]][0] = board[cur][0];
                    queue.offer(board[cur][1]);
                    continue;
                }
            }
            if (cur < 100) {
                if (board[cur + 1][0] == 0) {
                    board[cur + 1][0] = board[cur][0] + 1;
                    queue.offer(cur + 1);
                }
            }
            if (cur < 99) {
                if (board[cur + 2][0] == 0) {
                    board[cur + 2][0] = board[cur][0] + 1;
                    queue.offer(cur + 2);
                }
            }
            if (cur < 98) {
                if (board[cur + 3][0] == 0) {
                    board[cur + 3][0] = board[cur][0] + 1;
                    queue.offer(cur + 3);
                }
            }
            if (cur < 97) {
                if (board[cur + 4][0] == 0) {
                    board[cur + 4][0] = board[cur][0] + 1;
                    queue.offer(cur + 4);
                }
            }
            if (cur < 96) {
                if (board[cur + 5][0] == 0) {
                    board[cur + 5][0] = board[cur][0] + 1;
                    queue.offer(cur + 5);
                }
            }
            if (cur < 95) {
                if (board[cur + 6][0] == 0) {
                    board[cur + 6][0] = board[cur][0] + 1;
                    queue.offer(cur + 6);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int teleports = Integer.parseInt(input[0]) + Integer.parseInt(input[1]);

        for (int i = 0; i < teleports; i++) {
            input = br.readLine().split(" ");
            board[Integer.parseInt(input[0])][1] = Integer.parseInt(input[1]);
        }
        BFS();
        bw.write(board[100][0] - 1 + "");

        bw.close();
        br.close();
    }
}