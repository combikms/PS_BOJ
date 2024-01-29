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
        int[] wine = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            bw.write(wine[1] + "");
            bw.flush();
            bw.close();
            br.close();
            return;
        } else if (N == 2) {
            bw.write(wine[1] + wine[2] + "");
            bw.flush();
            bw.close();
            br.close();
            return;
        } else {
            dp[1] = wine[1];
            dp[2] = wine[1] + wine[2];
            dp[3] = Math.max(Math.max(wine[1] + wine[2], wine[1] + wine[3]), wine[2] + wine[3]);

            for (int i = 4; i <= N; i++) {
                dp[i] = Math.max(dp[i - 2], Math.max(dp[i - 3], dp[i - 4]) + wine[i - 1]) + wine[i];
            }

            bw.write(Math.max(dp[N - 1], dp[N]) + "");
            bw.flush();

            bw.close();
            br.close();
        }
    }
}
