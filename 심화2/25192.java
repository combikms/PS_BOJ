import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        int count = 0;
        int buffer = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                count += buffer;
                buffer = 0;
                set.clear();
            } else {
                set.add(input);
                buffer = set.size();
            }
        }
        count += buffer;
        bw.write(count + "");

        bw.close();
        br.close();
    }
}