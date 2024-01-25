import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

        double average = (double) sigma / N;
        average = Math.round(average);
        bw.write((int) average + "\n");

        bw.write(arr.get(N / 2) + "\n");

        int max = 1;
        for (int value : map.values()) {
            if (value > max) {
                max = value;
            }
        }

        int count = 0;
        int mode = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                count++;
                mode = entry.getKey();
                if (count == 2) {
                    break;
                }
            }
        }
        bw.write(mode + "\n");

        bw.write(arr.get(arr.size() - 1) - arr.get(0) + "");

        bw.flush();

        bw.close();
        br.close();
    }
}