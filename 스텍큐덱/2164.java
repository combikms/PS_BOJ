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
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(i + 1);
        }

        while (queue.size() != 1) {
            queue.remove(0);
            queue.add(queue.get(0));
            queue.remove(0);
        }

        bw.write(queue.get(0) + "");
        bw.flush();

        br.close();
        bw.close();
    }

}