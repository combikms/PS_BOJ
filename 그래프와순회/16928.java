import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;
import java.io.IOException;

public class Main {
    private static Queue<Integer> queue = new LinkedList<>();
    private static int[] board = new int[101];
    private static int[] moves = new int[101];

    public static int BFS() {
        queue.offer(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;

                if (next > 100) {
                    continue;
                }

                next = board[next] == 0 ? next : board[next];

                if (next == 1 || moves[next] != 0) {
                    continue;
                }

                queue.offer(next);
                moves[next] = moves[cur] + 1;
            }
        }

        return moves[100];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int teleports = Integer.parseInt(input[0]) + Integer.parseInt(input[1]);

        for (int i = 0; i < teleports; i++) {
            input = br.readLine().split(" ");
            board[Integer.parseInt(input[0])] = Integer.parseInt(input[1]);
        }

        bw.write(BFS() + "");
        bw.flush();

        bw.close();
        br.close();
    }
}