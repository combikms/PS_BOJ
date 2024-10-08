import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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

        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(A[0]);
        int start, end, mid, pos;

        for (int i = 1; i < N; i++) {
            start = 0;
            end = lis.size() - 1;
            pos = 0;

            if (lis.get(lis.size() - 1) < A[i]) {
                lis.add(A[i]);
            } else {
                while (start <= end) {
                    mid = start + (end - start) / 2;
                    if (lis.get(mid) < A[i]) {
                        start = mid + 1;
                    } else {
                        pos = mid;
                        end = mid - 1;
                    }
                }
                lis.set(pos, A[i]);
            }
        }

        bw.write(lis.size() + "");
        bw.flush();

        bw.close();
        br.close();
    }
}