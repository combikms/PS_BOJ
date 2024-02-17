import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    private static int[] parent;
    private static int[] rank;

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
            rank[rootB]++;
        }
    }

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(input[j]) == 1) {
                    union(i, j);
                }
            }
        }

        input = br.readLine().split(" ");
        int root = find(Integer.parseInt(input[0]) - 1);
        boolean isAvailable = true;
        for (int i = 1; i < M; i++) {
            if (find(Integer.parseInt(input[i]) - 1) != root) {
                isAvailable = false;
                break;
            }
        }

        if (isAvailable) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}