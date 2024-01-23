import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static long isPrime(long N) {
        if (N < 2) {
            return 0;
        }
        else {
            for (long i=2; i<Math.sqrt(N); i++) {
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
        for (int i=0; i<T; i++) {
            long n = Long.parseLong(br.readLine());
            while (true) {
                n++;
                if (isPrime(n) == 1) {
                    bw.write(n+"\n");
                    break;
                }
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }

}