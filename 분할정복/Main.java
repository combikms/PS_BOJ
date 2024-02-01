import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    private static final long MOD = 1000;

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

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long B = Long.parseLong(input[1]);

        long[][] A = new long[N][N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                A[i][j] = Long.parseLong(input[j]);
            }
        }

        long[][] C = fastpow(A, B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(C[i][j] % MOD + " ");
            }
            bw.write("\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}