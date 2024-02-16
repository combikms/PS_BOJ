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

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int sum;

        int[] min = new int[3];
        min[0] = arr[left];
        min[1] = arr[right];
        min[2] = Math.abs(arr[left] + arr[right]);

        while (left < right) {
            sum = arr[left] + arr[right];
            if (Math.abs(sum) < min[2]) {
                min[2] = Math.abs(sum);
                min[0] = arr[left];
                min[1] = arr[right];
            }
            if (sum == 0) {
                bw.write(arr[left] + " " + arr[right]);
                bw.flush();
                return;
            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        bw.write(min[0] + " " + min[1]);
        bw.flush();

        bw.close();
        br.close();
    }
}