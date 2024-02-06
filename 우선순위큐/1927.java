import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        int input;
        for (int i = 0; i < N; i++) {
            input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (pq.isEmpty()) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.add(input);
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }
}