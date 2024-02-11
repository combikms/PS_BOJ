import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] parent;

    public static void DFS(List<List<Integer>> V, int R) {
        visited[R] = true;
        for (int x : V.get(R)) {
            if (!visited[x]) {
                parent[x] = R;
                DFS(V, x);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        String[] input;
        for (int i = 0; i < N - 1; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        DFS(graph, 1);

        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}