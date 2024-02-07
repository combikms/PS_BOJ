import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.io.IOException;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static boolean[] visited;
    private static int count = -1;

    public static void visit(int x) {
        visited[x] = true;
        count++;
    }

    public static void DFS(List<List<Integer>> V, int R) {
        visit(R);
        List<Integer> neighbor = new ArrayList<>(V.get(R));
        Collections.sort(neighbor, Comparator.reverseOrder());
        for (int x : neighbor) {
            if (!visited[x]) {
                DFS(V, x);
            }
        }
    }

    public static void BFS(List<List<Integer>> V, int R) {
        visit(R);
        queue.offer(R);
        while (!queue.isEmpty()) {
            List<Integer> neighbor = new ArrayList<>(V.get(queue.poll()));
            Collections.sort(neighbor, Comparator.reverseOrder());
            for (int x : neighbor) {
                if (visited[x] != true) {
                    visit(x);
                    queue.offer(x);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        } // O(N) <= 100,000

        String[] input;
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        } // O(M) <= 200,000

        BFS(graph, 1);
        bw.write(count + "");
        bw.flush();

        bw.close();
        br.close();
    }
}