import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int M;

    public static void backtrack(ArrayList<Integer> stack, boolean[] used) throws IOException {
        if (stack.size() == M) {
            for (int number : stack) {
                bw.write(number + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                stack.add(i);

                backtrack(stack, used);

                stack.remove(stack.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        ArrayList<Integer> stack = new ArrayList<>();
        boolean[] used = new boolean[N + 1];

        backtrack(stack, used);

        bw.flush();
        br.close();
        bw.close();
    }
}