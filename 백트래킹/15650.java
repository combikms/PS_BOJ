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

    public static void backtrack(ArrayList<Integer> stack) throws IOException {
        if (stack.size() == M) {
            for (int number : stack) {
                bw.write(number + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isValid(stack, i)) {
                stack.add(i);
                backtrack(stack);
                stack.remove(stack.size() - 1);
            }
        }
    }

    public static boolean isValid(ArrayList<Integer> stack, int number) {
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i) >= number) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        ArrayList<Integer> stack = new ArrayList<>();

        backtrack(stack);

        bw.flush();
        br.close();
        bw.close();
    }
}