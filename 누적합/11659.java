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

        input = br.readLine().split(" ");
        int[][] arr = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            arr[i][0] = Integer.parseInt(input[i - 1]);
            arr[i][1] = arr[i - 1][1] + Integer.parseInt(input[i - 1]);
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            bw.write(
                    arr[Integer.parseInt(input[1])][1]
                            - arr[Integer.parseInt(input[0]) - 1][1]
                            + "\n");
        }
        bw.flush();

        bw.close();
        br.close();

    }
}