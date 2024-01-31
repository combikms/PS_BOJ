import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] distance = new long[N];
        long[] oilprice = new long[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            oilprice[i] = Integer.parseInt(input[i]);
        }

        long ans = 0;
        long next_distance = -1;
        int current = 0;

        for (int i = 0; i < N; i++) {
            if (oilprice[i] < oilprice[current]) {
                next_distance = 0;
                for (int j = current; j < i; j++) {
                    next_distance += distance[j];
                }
                ans += oilprice[current] * next_distance;
                current = i;
            } // 주유하고 목적지까지 이동
        }

        next_distance = 0;
        for (int i = current; i < N - 1; i++) {
            next_distance += distance[i];
        }
        ans += oilprice[current] * next_distance;

        long sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += distance[i];
        }

        if (next_distance == -1) {
            bw.write(oilprice[0] * sum + "");
        } else {
            bw.write(ans + "");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}