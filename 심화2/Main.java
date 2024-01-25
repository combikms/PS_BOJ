import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(input[i]));
        }
        bw.write(set.first() * set.last() + "");        
        bw.close();
        br.close();
    }
}