import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    private static int[] parent;
    private static int[] rank;

    private static boolean lose = false;

    // a가 속한 집합과 b가 속한 집합 합치기
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            lose = true;
            return;
        }

        // 랭크가 더 높은 집합이 더 낮은 집합을 흡수
        // 동등한 랭크끼리 붙이면 흡수하는 쪽(B)을 승급
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
            rank[rootB]++;
        }
    }

    // x의 루트(가장 높은 부모) 찾기
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 점의 수
        int m = Integer.parseInt(input[1]); // 시행 횟수

        // 초기 상태: 모든 원소가 다 서로 쪼개져 있고 랭크가 동등함
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int lose_point = 0;
        boolean writed = false;
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            union(a, b);
            if (lose && !writed) {
                lose_point = i + 1;
                writed = true;
            }
        }
        bw.write(lose_point + "");
        bw.flush();

        bw.close();
        br.close();
    }
}


