import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static int GCD(int A, int B) {
        int result = 1;
        for (int i = 1; i <= A; i++) {
            if (A % i == 0 && B % i == 0) {
                result = i;
            }
        }
        return result;
    }

    public static int LCM(int A, int B) {
        int N = GCD(A, B);
        return N * (A / N) * (B / N);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] input;
        int A;
        int B;

        for (int i = 0; i < T; i++) {
            input = br.readLine().split(" ");
            A = Integer.parseInt(input[0]);
            B = Integer.parseInt(input[1]);
            bw.write(LCM(A, B) + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }

}