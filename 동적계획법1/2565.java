import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] line = new int[N][2];

        String[] input;
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                line[i][j] = Integer.parseInt(input[j]);
            }
        }

        Arrays.sort(line, Comparator.comparingInt(arr -> arr[0]));

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (line[j][1] < line[i][1] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = dp[0];
        for (int i = 0; i < N; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        bw.write(N - max + "");
        bw.flush();

        bw.close();
        br.close();

    }
}