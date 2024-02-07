import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.io.IOException;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static boolean[] visited;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void visit(int x) throws IOException {
        visited[x] = true;
        bw.write(x + " ");
    }

    public static void DFS(List<List<Integer>> V, int R) throws IOException {
        visit(R);
        List<Integer> neighbor = new ArrayList<>(V.get(R));
        Collections.sort(neighbor);
        for (int x : neighbor) {
            if (!visited[x]) {
                DFS(V, x);
            }
        }
    }

    public static void BFS(List<List<Integer>> V, int R) throws IOException {
        visit(R);
        queue.offer(R);
        while (!queue.isEmpty()) {
            List<Integer> neighbor = new ArrayList<>(V.get(queue.poll()));
            Collections.sort(neighbor);
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

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);

        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        } // O(N) <= 100,000

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        } // O(M) <= 200,000

        DFS(graph, V);

        for (int i = 0; i < N + 1; i++) {
            visited[i] = false;
        }
        bw.write("\n");

        BFS(graph, V);

        bw.flush();

        bw.close();
        br.close();
    }
}