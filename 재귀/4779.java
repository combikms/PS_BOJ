import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static void Cant(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int n = r - l + 1;
        int start = l + n / 3;
        int end = l + 2 * n / 3 - 1;
        for (int i = start; i <= end; i++) {
            arr[i] = 0;
        }
        Cant(arr, l, start - 1);
        Cant(arr, end + 1, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N;
        String input;
        int[] arr;
        while ((input = br.readLine()) != null) {
            N = Integer.parseInt(input);
            arr = new int[(int) Math.pow(3, N)];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;
            }
            Cant(arr, 0, arr.length - 1);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    bw.write("-");

                } else if (arr[i] == 0) {
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