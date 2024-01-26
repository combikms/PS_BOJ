import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    private static int cnt = 0;

    public static int recursion(String S, int l, int r) {
        cnt++;

        if (l >= r)
            return 1;
        else if (S.charAt(l) != S.charAt(r))
            return 0;
        else
            return recursion(S, l + 1, r - 1);
    }

    public static int isPanlindrome(String S) {
        return recursion(S, 0, S.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        String S;
        for (int i = 0; i < T; i++) {
            S = br.readLine();
            bw.write(isPanlindrome(S) + " " + cnt + "\n");
            cnt = 0;
        }
        bw.flush();

        bw.close();
        br.close();
    }
}