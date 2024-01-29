import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int[] dp = new int[X + 1];
        dp[X] = 0;

        for (int i = X - 1; i >= 1; i--) {
            if (i * 2 > X) {
                dp[i] = dp[i + 1] + 1;
            } else if (i * 3 > X && i * 2 <= X) {
                dp[i] = Math.min(dp[i + 1], dp[i * 2]) + 1;
            } else {
                dp[i] = Math.min(Math.min(dp[i + 1], dp[i * 2]), dp[i * 3]) + 1;
            }
        }
        bw.write(dp[1] + "");
        bw.flush();

        bw.close();
        br.close();
    }
}