import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static int Search(int[] arr, int n, int start, int end) {
        if (start > end) {
            if (n == arr[0]) {
                return 1;
            } else {
                return 0;
            }
        }

        int mid = start + (end - start) / 2;
        int result = 0;

        if (n == arr[mid]) {
            return 1;
        } else if (n < arr[mid]) {
            result = Search(arr, n, start, mid - 1);
        } else {
            result = Search(arr, n, mid + 1, end);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        bw.close();
        br.close();
    }
}