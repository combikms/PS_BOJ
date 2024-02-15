import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static boolean isBi = true;

    public static void DFS(int R) {
        if (!isBi) {
            return;
        }

        visited[R] = true;
        for (int x : graph.get(R)) {
            if (!visited[x]) {
                DFS(R);
            } else {

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
            visited = new boolean[Integer.parseInt(input[0]) + 1];
            for (int j = 0; j <= Integer.parseInt(input[0]); j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < Integer.parseInt(input[1]); j++) {
                input = br.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            // 이분 그래프 여부 검사 결과 출력

            graph.clear();
        }
        bw.flush();

        bw.close();
        br.close();
    }
}