import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;
import java.io.IOException;

public class Main {
    private static Queue<Integer> queue = new LinkedList<>();

    public static void BFS() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] board = new int[N][M];

        String S;
        for (int i = 0; i < N; i++) {
            S = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = S.charAt(j) - '0';
            }
        }

        bw.close();
        br.close();
    }
}