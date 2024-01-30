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
        int K = Integer.parseInt(input[1]);

        int[][] arr = new int[N + 1][2];

        input = br.readLine().split(" ");
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            arr[i][0] = Integer.parseInt(input[i - 1]);

            if (i > K) {
                arr[i][1] = arr[i - 1][1] - arr[i - K][0] + Integer.parseInt(input[i - 1]);
                if (arr[i][1] > max) {
                    max = arr[i][1];
                }
            } else {
                arr[i][1] = arr[i - 1][1] + Integer.parseInt(input[i - 1]);
                if (i == K) {
                    if (arr[i][1] > max) {
                        max = arr[i][1];
                    }
                }
            }

        }

        bw.write(max + "");

        bw.close();
        br.close();

    }
}