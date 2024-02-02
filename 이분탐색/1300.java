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

        long N = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long start = 1;
        long end = N * N;

        long mid = 0;
        long count = 0;
        long result = 0;

        while (start <= end) {
            count = 0;
            mid = start + (end - start) / 2;

            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count < k) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }

        bw.write(result + "");
        bw.flush();

        bw.close();
        br.close();
    }
}