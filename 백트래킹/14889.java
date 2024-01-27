import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    private static int N;
    private static int[][] S;
    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;

    public static int Calc(int[][] S, boolean[] visited) {
        int start_point = 0;
        int link_point = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start_point += (S[i][j] + S[j][i]);
                } else if (!visited[i] && !visited[j]) {
                    link_point += (S[i][j] + S[j][i]);
                }
            }
        }

        return Math.abs(start_point - link_point);
    }

    public static void backtrack(int player, int count) {

        if (count == N / 2) {
            int diff = Calc(S, visited);
            min = Math.min(min, diff);
            return;
        }

        for (int i = player; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        String[] input;
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(input[j]);
            }
        }

        backtrack(0, 0);

        bw.write(min + "");
        bw.flush();

        br.close();
        bw.close();
    }
}