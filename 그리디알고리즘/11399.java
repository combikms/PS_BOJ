import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            if (i > 0) {
                arr[i] = arr[i] + arr[i - 1];
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        bw.write(sum + "");
        bw.flush();

        bw.close();
        br.close();
    }
}