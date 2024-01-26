import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static void Erase(int[][] arr, int s_x, int s_y, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 3;
        int start_x = s_x + newSize;
        int end_x = s_x + 2 * newSize;
        int start_y = s_y + newSize;
        int end_y = s_y + 2 * newSize;

        for (int i = start_x; i < end_x; i++) {
            for (int j = start_y; j < end_y; j++) {
                arr[i][j] = 0;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1)
                    continue;
                Erase(arr, s_x + i * newSize, s_y + j * newSize, newSize);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = 1;
            }
        }

        Erase(arr, 0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    bw.write("*");
                } else {
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}