import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Main {
    // {정점, 간선길이}
    private static List<List<int[]>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int max = 0;
    private static int farNode = 0;

    public static void DFS(int node, int dist) {
        visited[node] = true;

        if (dist > max) {
            max = dist;
            farNode = node;
        }

        for (int[] neighbor : graph.get(node)) {
            int nextNode = neighbor[0];
            int weight = neighbor[1];

            if (!visited[nextNode]) {
                DFS(nextNode, dist + weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int V = Integer.parseInt(br.readLine());
        visited = new boolean[V + 1];
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        String[] input;
        for (int i = 0; i < V; i++) {
            input = br.readLine().split(" ");
            int Node = Integer.parseInt(input[0]);
            for (int j = 1; Integer.parseInt(input[j]) != -1; j += 2) {
                int nextNode = Integer.parseInt(input[j]);
                int dist = Integer.parseInt(input[j + 1]);
                graph.get(Node).add(new int[] { nextNode, dist });
            }
        }

        DFS(1, 0);

        visited = new boolean[V + 1];
        max = 0;

        DFS(farNode, 0);

        bw.write(max + "");
        bw.flush();

        bw.close();
        br.close();
    }
}