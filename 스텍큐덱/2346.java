import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.io.IOException;

public class Main {

    public static class balloon {
        int number;
        int paper;

        public balloon(int number, int paper) {
            this.number = number;
            this.paper = paper;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<balloon> deque = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            deque.add(new balloon(i + 1, Integer.parseInt(input[i])));
        }

        int cur = 0;
        while (!deque.isEmpty()) {
            int paper = deque.get(cur).paper;
            bw.write(deque.get(cur).number + " ");
            deque.remove(cur);
            if (deque.isEmpty())
                break;
            if (paper > 0) {
                cur = (cur + paper - 1) % deque.size();
            } else {
                cur = (deque.size() - ((-paper) % deque.size()) + cur) % deque.size();
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }

}