import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    private static int K = 0;
    private static int cnt = 0;
    private static int result = 0;

    public static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    public static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                cnt++;
                if (cnt == K) {
                    result = tmp[part1];
                }
                arr[index] = tmp[part1];
                part1++;
            } else {
                cnt++;
                if (cnt == K) {
                    result = tmp[part2];
                }
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++) {
            cnt++;
            if (cnt == K) {
                result = tmp[part1 + i];
            }
            arr[index + i] = tmp[part1 + i];
        }
        for (int i = part2; i <= end; i++) {
            cnt++;
            if (cnt == K) {
                result = tmp[i];
            }
            arr[index++] = tmp[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        mergeSort(arr);

        if (result == 0) {
            bw.write(-1 + "");
        } else {
            bw.write(result + "");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}