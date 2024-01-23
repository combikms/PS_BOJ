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

        int T = Integer.parseInt(br.readLine());

        boolean[] isComposite = new boolean[1000001];
        for (int i = 2; i <= 1000; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int partitions = 0;
            for (int j = 2; j <= N / 2; j++) {
                if (!isComposite[j] && !isComposite[N - j]) {
                    partitions++;
                }
            }
            bw.write(partitions + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }

}