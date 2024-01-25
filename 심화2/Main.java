import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int input;
        int sigma = 0;        
        for (int i = 0; i < N; i++) {
            input = Integer.parseInt(br.readLine());
            arr.add(input);
            sigma += input;
            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
            } else {
                map.put(input, 1);
            }
        }
        arr.sort(Comparator.naturalOrder());

        bw.write(sigma / N + "\n");
        bw.write(arr.get(N / 2 + 1) + "\n");
        //여기에 최빈값을 구하는 코드를 작성하려면?
        bw.write(arr.get(arr.size() - 1) - arr.get(0));

        bw.flush();

        bw.close();
        br.close();
    }
}