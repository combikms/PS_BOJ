import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void DFS(List<List<Integer>> V, int R, int opt) throws IOException {
        // <OPT>
        // 1: pre
        // 2: in
        // 3:post

        if (opt == 1) {
            visited[R] = true;
            bw.write((char) (R + 'A') + "");

            for (int child : V.get(R)) {
                if (child != -19 && !visited[child]) {
                    DFS(V, child, 1);
                }
            }
        } else if (opt == 2) {
            int left = V.get(R).get(0);
            int right = V.get(R).get(1);
            if (left != -19 && !visited[left]) {
                DFS(V, left, 2);
            }
            visited[R] = true;
            bw.write((char) (R + 'A') + "");
            if (right != -19 && !visited[right]) {
                DFS(V, right, 2);
            }
        } else {
            for (int child : V.get(R)) {
                if (child != -19 && !visited[child]) {
                    DFS(V, child, 3);
                }
            }
            visited[R] = true;
            bw.write((char) (R + 'A') + "");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        String[] input;
        char Node, l, r;
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            Node = input[0].charAt(0);
            l = input[1].charAt(0);
            r = input[2].charAt(0);

            graph.get(Node - 'A').add(l - 'A');
            graph.get(Node - 'A').add(r - 'A');
        }

        DFS(graph, 0, 1);
        bw.write("\n");
        visited = new boolean[N + 1];

        DFS(graph, 0, 2);
        bw.write("\n");
        visited = new boolean[N + 1];

        DFS(graph, 0, 3);
        bw.flush();

        bw.close();
        br.close();
    }
}