import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        int[] lis = new int[N];
        int[] lds = new int[N];

        for (int i = 0; i < N; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (A[i] > A[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int max = 1;
        for (int i = 0; i < N; i++) {
            if (lis[i] + lds[i] > max) {
                max = lis[i] + lds[i];
            }
        }
        bw.write(max - 1 + "");
        bw.flush();

        bw.close();
        br.close();

    }
}