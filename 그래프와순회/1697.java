import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class Main {
    private static int N = 0;
    private static int K = 0;
    private static int[] road;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void BFS(int start) {
        road[start] = 1;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur < K * 2 - 1) {
                if (road[cur + 1] == 0) {
                    road[cur + 1] = road[cur] + 1;
                    queue.offer(cur + 1);
                }
            }
            if (cur > 0) {
                if (road[cur - 1] == 0) {
                    road[cur - 1] = road[cur] + 1;
                    queue.offer(cur - 1);
                }
            }
            if (cur < K) {
                if (road[cur * 2] == 0) {
                    road[cur * 2] = road[cur] + 1;
                    queue.offer(cur * 2);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        road = new int[Math.max(N, K) * 2 + 1];
        BFS(N);

        bw.write(road[K] - 1 + "");
        bw.flush();

        bw.close();
        br.close();
    }
}