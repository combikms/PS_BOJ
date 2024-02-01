import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int zero = 0;
    private static int plus = 0;
    private static int minus = 0;

    public static int isFull(int[][] arr, int s_x, int s_y, int length) {
        int color = arr[s_x][s_y];
        for (int i = s_x; i < s_x + length; i++) {
            for (int j = s_y; j < s_y + length; j++) {
                if (arr[i][j] != color) {
                    return -2;
                }
            }
        }
        return color;
    }

    public static void divide(int[][] arr, int s_x, int s_y, int length) throws IOException {

        int temp = isFull(arr, s_x, s_y, length);

        if (temp == 1) {
            plus++;
            return;
        } else if (temp == 0) {
            zero++;
            return;
        } else if (temp == -1) {
            minus++;
            return;
        }

        divide(arr, s_x, s_y, length / 3);
        divide(arr, s_x + (length / 3), s_y, length / 3);
        divide(arr, s_x + 2 * (length / 3), s_y, length / 3);
        divide(arr, s_x, s_y + (length / 3), length / 3);
        divide(arr, s_x + (length / 3), s_y + (length / 3), length / 3);
        divide(arr, s_x + 2 * (length / 3), s_y + (length / 3), length / 3);
        divide(arr, s_x, s_y + 2 * (length / 3), length / 3);
        divide(arr, s_x + (length / 3), s_y + 2 * (length / 3), length / 3);
        divide(arr, s_x + 2 * (length / 3), s_y + 2 * (length / 3), length / 3);

        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        String[] input;
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[j][i] = Integer.parseInt(input[j]);
            }
        }

        divide(arr, 0, 0, N);

        bw.write(minus + "\n" + zero + "\n" + plus);
        bw.flush();

        bw.close();
        br.close();
    }
}