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
    private static boolean isTree = true;

    public static void DFS(List<List<Integer>> V, int R, int parent) {
        if (!isTree) {
            return;
        }
        visited[R] = true;
        for (int x : V.get(R)) {
            if (!visited[x]) {
                DFS(V, x, R);
            } else {
                if (x != parent) {
                    isTree = false;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input;
        int case_num = 1;
        while (true) {
            input = br.readLine().split(" ");
            int Nodes = Integer.parseInt(input[0]);
            int lines = Integer.parseInt(input[1]);
            if (Nodes == 0 && lines == 0) {
                break;
            }

            int count = 0;
            visited = new boolean[Nodes + 1];
            graph.clear();
            for (int i = 0; i <= Nodes; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < lines; i++) {
                input = br.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            for (int i = 1; i <= Nodes; i++) {
                if (!visited[i]) {
                    isTree = true;
                    DFS(graph, i, -1);
                    if (isTree) {
                        count++;
                    }
                }
            }

            bw.write("Case " + case_num + ": ");

            if (count == 0) {
                bw.write("No trees.\n");
            } else if (count == 1) {
                bw.write("There is one tree.\n");
            } else {
                bw.write("A forest of " + count + " trees.\n");
            }

            case_num++;
        }
        bw.flush();

        bw.close();
        br.close();
    }
}