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

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            int count = 0;
            for (int i = N + 1; i <= 2 * N; i++) {
                if (isPrime(i) == 1) {
                    count++;
                }
            }
            bw.write(count+"\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

}