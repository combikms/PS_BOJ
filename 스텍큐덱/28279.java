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

        LinkedList<Integer> deque = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        String[] input;
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int menu = Integer.parseInt(input[0]);

            switch (menu) {
                case 1:
                    deque.addFirst(Integer.parseInt(input[1]));
                    break;
                case 2:
                    deque.addLast(Integer.parseInt(input[1]));
                    break;
                case 3:
                    if (deque.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(deque.getFirst() + "\n");
                        deque.removeFirst();
                    }
                    break;
                case 4:
                    if (deque.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(deque.getLast() + "\n");
                        deque.removeLast();
                    }
                    break;
                case 5:
                    bw.write(deque.size() + "\n");
                    break;
                case 6:
                    if (deque.isEmpty()) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;
                case 7:
                    if (deque.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(deque.getFirst() + "\n");
                    }
                    break;
                case 8:
                    if (deque.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(deque.getLast() + "\n");
                    }
                    break;
                default:
                    return;
            }

        }
        bw.flush();

        bw.close();
        br.close();
    }

}