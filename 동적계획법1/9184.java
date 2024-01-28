import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.IOException;

public class Main {

    private static int[][][] arr = new int[21][21][21];

    public static int w(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }
        if (arr[a][b][c] != -1) {
            return arr[a][b][c];
        }
        if (a < b && b < c) {
            arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
        return arr[a][b][c];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                Arrays.fill(arr[i][j], -1);
            }
        }

        String[] input;
        while (true) {
            input = br.readLine().split(" ");
            if (Integer.parseInt(input[0]) == -1 &&
                    Integer.parseInt(input[1]) == -1 &&
                    Integer.parseInt(input[2]) == -1) {
                break;
            }
            bw.write("w(" + input[0] + ", " + input[1] + ", " + input[2] + ") = " +
                    w(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])) + "\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}