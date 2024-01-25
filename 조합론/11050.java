import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static int fact(int N) {
        int result = 1;
        for (int i = 1; i <= N; i++) {
            result *= i;
        }
        return result;
    }

    public static int Combination(int N, int R) {
        int boonja = 1;
        int boonmo = fact(R);

        for (int i = N; i >= N - R + 1; i--) {
            boonja *= i;
        }

        return boonja / boonmo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        bw.write(Combination(N, R) + "");
        bw.flush();

        bw.close();
        br.close();
    }

}