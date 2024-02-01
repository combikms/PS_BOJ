import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    private static long C;

    public static long fastpow(long A, long B) {
        if (B == 0) {
            return 1;
        }

        long half = fastpow(A, B / 2);
        long temp = (half * half) % C;

        if (B % 2 == 0) {
            return temp;
        } else {
            return (A * temp) % C;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);
        C = Long.parseLong(input[2]);

        bw.write(fastpow(A, B) % C + "");

        bw.close();
        br.close();
    }
}