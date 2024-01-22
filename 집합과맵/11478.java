import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        Set<String> part = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            for (int j = i; j <= S.length(); j++) {
                part.add(S.substring(i, j));
            }
        }

        bw.write(part.size() - 1 + "");
        bw.flush();

        br.close();
        bw.close();
    }

}