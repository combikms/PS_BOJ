import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());
        String input[];
        int[][] arr = new int[S.length()][26];
        for (int i = 0; i < S.length(); i++) {
            if (i > 0) {
                for (int j = 0; j < 26; j++) {
                    arr[i][j] = arr[i - 1][j];
                }
            }
            arr[i][S.charAt(i) - 'a']++;
        }

        for (int i = 0; i < q; i++) {
            input = br.readLine().split(" ");
            int ans;
            if (Integer.parseInt(input[1]) > 0) {
                ans = arr[Integer.parseInt(input[2])][input[0].charAt(0) - 'a']
                        - arr[Integer.parseInt(input[1]) - 1][input[0].charAt(0) - 'a'];
            } else {
                ans = arr[Integer.parseInt(input[2])][input[0].charAt(0) - 'a'];
            }
            bw.write(ans + "\n");
        }
        bw.flush();

        bw.close();
        br.close();

    }
}