import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

    private static int A = 0;
    private static int B = 0;

    // 무지성 재귀 코드
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            A++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // 동적 프로그래밍 코드
    public static int fibonacci(int n) {
        ArrayList<Integer> f = new ArrayList<>();
        f.add(1);
        f.add(2);
        for (int i = 3; i <= n; i++) {
            f.add(f.get(f.size() - 1) + f.get(f.size() - 2));
            B++;
        }
        return f.get(f.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int a = fib(N);
        int b = fibonacci(N);

        bw.write(A + " " + B);
        bw.flush();

        bw.close();
        br.close();
    }
}