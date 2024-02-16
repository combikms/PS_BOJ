import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int[] colors;
    private static boolean isBi = true;

    public static void visit(int R, int color) {
        colors[R] = color;
    }

    public static void DFS(int R, int color) {
        visit(R, color);
        for (int x : graph.get(R)) {
            if (colors[x] == 0) {
                DFS(x, -color);
            } else {
                if (colors[x] == color) {
                    isBi = false;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] input;
        for (int i = 0; i < T; i++) {
            input = br.readLine().split(" ");
            int nodes = Integer.parseInt(input[0]);
            int lines = Integer.parseInt(input[1]);

            colors = new int[nodes + 1];
            for (int j = 0; j <= nodes; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < lines; j++) {
                input = br.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            for (int j = 1; j <= nodes; j++) {
                if (colors[j] == 0) {
                    DFS(j, 1);
                }
            }

            if (isBi) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }

            isBi = true;
            graph.clear();
        }
        bw.flush();

        bw.close();
        br.close();
    }
}