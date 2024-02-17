import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Main {
    private static int C = 0;
    private static int arr[];
    private static ArrayList<Integer> left = new ArrayList<>();
    private static ArrayList<Integer> right = new ArrayList<>();

    public static void comb(ArrayList<Integer> list, int start, int end, int sum) {
        if (sum > C) {
            return;
        }
        if (start == end) {
            list.add(sum);
            return;
        }
        comb(list, start + 1, end, sum); // 안 넣기
        comb(list, start + 1, end, sum + arr[start]); // 넣기
    }

    public static int BS(int start, int end, int val) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (right.get(mid) + val <= C) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        arr = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        comb(left, 0, N / 2, 0); // O(2^N/2) <= 32,768
        comb(right, N / 2, N, 0); // O(2^N/2) <= 32,768

        right.sort((a, b) -> (a - b)); // O(2^N/2 * log(2^(N/2))) <= 491,520

        int ans = 0;
        int index = 0;

        for (int i = 0; i < left.size(); i++) {
            index = BS(0, right.size() - 1, left.get(i));
            ans += index + 1;
        } // O(2^N/2 * log(2^(N/2))) <= 491,520
        bw.write(ans + "");
        bw.flush();

        bw.close();
        br.close();
    }
}