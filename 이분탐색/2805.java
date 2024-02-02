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
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] tree = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(tree);

        int start = 1;
        int end = tree[N - 1];

        int mid = 0;
        long sum = 0;

        int result = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            sum = 0;

            for (int i = 0; i < N; i++) {
                if (mid < tree[i]) {
                    sum += tree[i] - mid;
                }
            }

            if (sum >= M) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        bw.write(result + "");
        bw.flush();

        bw.close();
        br.close();
    }
}