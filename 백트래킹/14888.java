import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static int Calc(int[] operand, int[] operator) {

        int result = operand[0];
        for (int i = 0; i < operand.length - 1; i++) {
            if (operator[i] == 1) {
                result += operand[i + 1];
            } // plus
            else if (operator[i] == 2) {
                result -= operand[i + 1];
            } // minus
            else if (operator[i] == 3) {
                result *= operand[i + 1];
            } // multiply
            else if (operator[i] == 4) {
                result /= operand[i + 1];
            } // divide
        }
        return result;
    }

    public static void backtrack(int[] operand, int[] operator, int[] num_operator, int index) {
        if (index == operator.length) {
            int result = Calc(operand, operator);
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < num_operator.length; i++) {
            if (num_operator[i] > 0) {
                operator[index] = i + 1;
                num_operator[i]--;

                backtrack(operand, operator, num_operator, index + 1);

                num_operator[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] operand = new int[N];
        int[] operator = new int[N - 1];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            operand[i] = Integer.parseInt(input[i]);
        }

        int[] num_operator = new int[4];
        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            num_operator[i] = Integer.parseInt(input[i]);
        }

        backtrack(operand, operator, num_operator, 0);
        bw.write(max + "\n" + min);

        bw.flush();
        br.close();
        bw.close();
    }
}