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

        int N = Integer.parseInt(br.readLine());
        int[] node = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            node[i] = Integer.parseInt(input[i]);
        }

        LinkedList<Integer> data = new LinkedList<>();
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            if (node[i] == 0) {
                data.add(Integer.parseInt(input[i]));
            }
        }

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            if (data.isEmpty()) {
                bw.write(input[i] + " ");
            } else {
                bw.write(data.getLast() + " ");
                data.addFirst(Integer.parseInt(input[i]));
                data.removeLast();
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }

}