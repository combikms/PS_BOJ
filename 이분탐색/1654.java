import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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

        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[] LAN = new int[K];
        for (int i = 0; i < K; i++) {
            LAN[i] = Integer.parseInt(br.readLine());
        } // O(K) <= 10,000
        Arrays.sort(LAN);

        long start = 1;
        long end = LAN[K - 1];
        long result = 0;

        long mid = 0;
        long sum = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            sum = 0;

            for (int i = 0; i < K; i++) {
                sum += LAN[i] / mid;
            }

            if (sum >= N) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } // O(log(LAN[K-1])) <= 31

        bw.write(result + "");
        bw.flush();

        bw.close();
        br.close();
    }
}