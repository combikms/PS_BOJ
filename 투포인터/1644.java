import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] isComposite = new boolean[4000001];
        for (int i = 2; i <= 2000; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= 4000000; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            bw.write(0 + "");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!isComposite[i]) {
                prime.add(i);
            }
        }

        int left = 0;
        int right = 0;
        int sum = prime.get(0);
        int ans = 0;

        while (true) {
            if (sum == N) {
                ans++;
                sum -= prime.get(left);
                left++;
            } else if (sum > N) {
                sum -= prime.get(left);
                left++;
            } else if (left == prime.size() - 1 || right == prime.size() - 1) {
                break;
            } else {
                right++;
                sum += prime.get(right);
            }
        }
        bw.write(ans + "");
        bw.flush();

        br.close();
        bw.close();
    }
}