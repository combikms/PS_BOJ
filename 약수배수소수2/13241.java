import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static long GCD(long A, long B) {

        if (A > B) {
            long L = A;
            long R = B;
            long temp = 1;

            while (L % R != 0) {
                temp = L;
                L = R;
                R = temp % R;
            }

            return R;
        } else {
            long L = B;
            long R = A;
            long temp = 1;

            while (L % R != 0) {
                temp = L;
                L = R;
                R = temp % R;
            }

            return R;
        }

    }

    public static long LCM(long A, long B) {
        long N = GCD(A, B);
        return N * (A / N) * (B / N);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        long A = Integer.parseInt(input[0]);
        long B = Integer.parseInt(input[1]);

        bw.write(LCM(A, B) + "");
        bw.flush();

        bw.flush();

        br.close();
        bw.close();
    }

}