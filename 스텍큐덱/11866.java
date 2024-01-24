import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> queue = new LinkedList<>();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        for (int i = 0; i < N; i++) {
            queue.add(i + 1);
        }
        bw.write("<");
        int cur = 0;
        while (queue.size() != 1) {
            cur = (cur + K - 1) % queue.size();
            bw.write(queue.get(cur) + ", ");
            queue.remove(cur);
        }
        bw.write(queue.get(0) + ">");
        bw.flush();

        bw.close();
        br.close();
    }

}