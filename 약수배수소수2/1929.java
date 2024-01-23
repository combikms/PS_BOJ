import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static int isPrime(int N) {
        if (N < 2) {
            return 0;
        } else {
            for (int i = 2; i <= (int) Math.sqrt(N); i++) {
                if (N % i == 0) {
                    return 0;
                }
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for (int i = N; i <= M; i++) {
            if (isPrime(i) == 1) {
                bw.write(i + "\n");
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }

}