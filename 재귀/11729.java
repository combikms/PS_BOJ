import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    private static int cnt = 0;
    private static int[][] log;
    private static int log_pointer = 0;

    public static void Hanoi(int N, int start, int dest, int buff) {
        if (N == 1) {
            cnt++;
            log[log_pointer][0] = start;
            log[log_pointer][1] = dest;
            log_pointer++;
            return;
        }
        Hanoi(N - 1, start, buff, dest);
        cnt++;
        log[log_pointer][0] = start;
        log[log_pointer][1] = dest;
        log_pointer++;
        Hanoi(N - 1, buff, dest, start);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        log = new int[(int)Math.pow(2, N) - 1][2];

        Hanoi(N, 1, 3, 2);

        bw.write(cnt + "\n");
        for (int i = 0; i < cnt; i++) {
            bw.write(log[i][0] + " " + log[i][1] + "\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}