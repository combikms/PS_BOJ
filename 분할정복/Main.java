import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    private static int blue = 0;
    private static int white = 0;

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

    public static void divide(int[][] arr, int s_x, int s_y, int length) {
        int temp = isFull(arr, s_x, s_y, length);

        if (temp > 0) {
            blue++;
            return;
        } else if (temp == 0) {
            white++;
            return;
        }

        divide(arr, s_x, s_y, length / 2);
        divide(arr, s_x + (length / 2), s_y, length / 2);
        divide(arr, s_x, s_y + (length / 2), length / 2);
        divide(arr, s_x + (length / 2), s_y + (length / 2), length / 2);

        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        String[] input;
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        divide(arr, 0, 0, N);

        bw.write(white + "\n" + blue);
        bw.flush();

        bw.close();
        br.close();
    }
}