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
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int sum = 0;
        int count = 0;
        while (left < right) {
            sum = arr[left] + arr[right];
            if (sum == x) {
                count++;
                left++;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }
        bw.write(count + "");
        bw.flush();

        bw.close();
        br.close();
    }
}