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
        int[] arr = new int[N];
        int[] dp = new int[N];
        String[] input = br.readLine().split(" ");
        arr[0] = Integer.parseInt(input[0]);
        dp[0] = arr[0];
        int max = dp[0];

        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(dp[i], max);
        }
        bw.write(max + "");
        bw.flush();

        bw.close();
        br.close();
    }
}
