import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    private static long MOD = 1000000007;

    public static long fact(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }

    public static long fastpow(long bs, long exp) {
        if (exp == 0) {
            return 1;
        }

        long half = fastpow(bs, exp / 2);
        long temp = (half * half) % MOD;

        if (exp % 2 == 0) {
            return temp;
        } else {
            return (bs * temp) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input;
        while (true) {
            input = br.readLine().split(" ");
            if (Integer.parseInt(input[0]) == 0) {
                break;
            }

            for (int i = 0; i < Integer.parseInt(input[0]); i++) {

            }

        }

        bw.close();
        br.close();
    }
}