import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    private static long MOD = 1000000007;

    public static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    C[i][j] += (A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    public static long[][] fastpow(long[][] C, long B) {
        long[][] result = new long[C.length][C[0].length];
        if (B == 0) {
            for (int i = 0; i < C.length; i++) {
                result[i][i] = 1;
            }
            return result;
        }

        long[][] half = fastpow(C, B / 2);

        if (B % 2 == 0) {
            return multiply(half, half);
        } else {
            return multiply(C, multiply(half, half));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        long[][] fibo = new long[2][2];
        fibo[0][0] = 1;
        fibo[0][1] = 1;
        fibo[1][0] = 1;
        fibo[1][1] = 0;

        long[][] result = fastpow(fibo, N);
        bw.write(result[0][1] % MOD + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}