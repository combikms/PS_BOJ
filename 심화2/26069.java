import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Boolean> map = new HashMap<>();
        map.put("ChongChong", true);

        String[] input;
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            if (map.containsKey(input[0]) && map.get(input[0]) || map.containsKey(input[1]) && map.get(input[1])) {
                map.put(input[0], true);
                map.put(input[1], true);
            } else {
                map.put(input[0], false);
                map.put(input[1], false);
            }
        }

        int count = 0;
        for (Boolean value : map.values()) {
            if (value) {
                count++;
            }
        }
        bw.write(count + "");

        bw.close();
        br.close();
    }
}