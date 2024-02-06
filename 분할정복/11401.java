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

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        //핵심: 모듈러 연산을 끼면서 나눗셈을 하기 어렵기 때문에 저런 곱셈 형태로 바꾼 것
        long ans = fact(N) % MOD * fastpow((fact(K) * fact(N - K)) % MOD, MOD - 2) % MOD;
        bw.write(ans + "");
        bw.flush();

        bw.close();
        br.close();
    }
}