import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] sum = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            if (i > 0) {
                sum[i] = (sum[i - 1] + Integer.parseInt(input[i])) % M;
            } else {
                sum[i] = Integer.parseInt(input[i]) % M;
            }
        }

        HashMap<Integer, Integer> remainder = new HashMap<>();
        remainder.put(0, 1);
        long answer = 0;

        for (int i = 0; i < N; i++) {
            answer += remainder.getOrDefault(sum[i], 0);
            remainder.put(sum[i], remainder.getOrDefault(sum[i], 0) + 1);
        }
        bw.write(answer + "");

        bw.close();
        br.close();

    }
}