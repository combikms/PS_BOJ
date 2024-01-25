import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Main {

// public static int fact(int N) {
// int result = 1;
// for (int i = 1; i <= N; i++) {
// result *= i;
// }
// return result;
// }

// public static int Combination(int N, int R) {
// int boonja = 1;
// int boonmo = fact(R);

// for (int i = N; i >= N - R + 1; i--) {
// boonja *= i;
// }

// return boonja / boonmo;
// }

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    String[] input;

    for (int i = 0; i < T; i++) {
        input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        BigInteger boonja = BigInteger.ONE;
        BigInteger boonmo = BigInteger.ONE;

        for (int j = N; j >= N - R + 1; j--) {
            boonja = boonja.multiply(BigInteger.valueOf(j));
        }
        for (int j = 2; j <= R; j++) {
            boonmo = boonmo.multiply(BigInteger.valueOf(j));
        }
        bw.write(boonja.divide(boonmo).toString() + "\n");
    }
    bw.flush();

    bw.close();
    br.close();
}
}