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
            String[] input = br.readLine().split(" ");
            String menu = input[0];

            switch (menu) {
                case "push":
                    queue.add(Integer.parseInt(input[1]));
                    break;

                case "pop":
                    if (queue.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(queue.get(0) + "\n");
                        queue.remove(0);
                    }

                    break;

                case "size":
                    bw.write(queue.size() + "\n");
                    break;

                case "empty":
                    if (queue.isEmpty()) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;

                case "front":
                    if (queue.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(queue.get(0) + "\n");
                    }
                    break;

                case "back":
                    if (queue.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(queue.get(queue.size() - 1) + "\n");
                    }
                    break;

                default:
                    return;
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }

}