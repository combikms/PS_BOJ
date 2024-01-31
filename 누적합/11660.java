import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + Integer.parseInt(input[j - 1]);
            }
        }

        int x1, x2, y1, y2;
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            x1 = Integer.parseInt(input[0]);
            y1 = Integer.parseInt(input[1]);
            x2 = Integer.parseInt(input[2]);
            y2 = Integer.parseInt(input[3]);

            bw.write(arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1] + "\n");
        }
        bw.flush();

        bw.close();
        br.close();

    }
}