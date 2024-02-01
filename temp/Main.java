import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int isFull(int[][] arr, int s_x, int s_y, int length) {
        int color = arr[s_x][s_y];
        for (int i = s_x; i < s_x + length; i++) {
            for (int j = s_y; j < s_y + length; j++) {
                if (arr[i][j] != color) {
                    return -1;
                }
            }
        }
        return color;
    }

    public static void divide(int[][] arr, int s_x, int s_y, int length) throws IOException {

        int temp = isFull(arr, s_x, s_y, length);

        if (temp > 0) {
            bw.write("1");
            return;
        } else if (temp == 0) {
            bw.write("0");
            return;
        }

        bw.write("(");
        divide(arr, s_x, s_y, length / 2);
        divide(arr, s_x + (length / 2), s_y, length / 2);
        divide(arr, s_x, s_y + (length / 2), length / 2);
        divide(arr, s_x + (length / 2), s_y + (length / 2), length / 2);
        bw.write(")");

        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        String input;
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[j][i] = input.charAt(j) - '0';
            }
        }

        divide(arr, 0, 0, N);
        bw.flush();

        bw.close();
        br.close();
    }
}