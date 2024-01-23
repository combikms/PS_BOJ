import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static int GCD(int A, int B) {

        if (A > B) {
            int L = A;
            int R = B;
            int temp = 1;

            while (L % R != 0) {
                temp = L;
                L = R;
                R = temp % R;
            }

            return R;
        } else {
            int L = B;
            int R = A;
            int temp = 1;

            while (L % R != 0) {
                temp = L;
                L = R;
                R = temp % R;
            }

            return R;
        }

    }

    public static int LCM(int A, int B) {
        int N = GCD(A, B);
        return N * (A / N) * (B / N);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int C = Integer.parseInt(input[0]);
        int D = Integer.parseInt(input[1]);

        int E = A * (LCM(B, D) / B) + C * (LCM(B, D) / D);
        int F = LCM(B, D);

        int gcd = GCD(E, F);
        E /= gcd;
        F /= gcd;

        bw.write(E + " " + F);
        bw.flush();

        br.close();
        bw.close();
    }

}