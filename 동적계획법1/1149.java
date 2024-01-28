import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];

        String[] input;
        for (int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }

        bw.write(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]) + "");
        bw.flush();

        bw.close();
        br.close();
    }
}