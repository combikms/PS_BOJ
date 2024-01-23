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

        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        int[] margins = new int[N - 1];

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N - 1; i++) {
            margins[i - 1] = trees[i] - trees[i - 1];
        }

        int gcd = margins[0];
        for (int i = 1; i < N - 1; i++) {
            gcd = GCD(gcd, margins[i]);
        }

        int count = 0;
        for (int i=0; i<N-1; i++) {
            count += (margins[i] / gcd) - 1;
        }
        bw.write(count+"");
        bw.flush();

        br.close();
        bw.close();
    }

}