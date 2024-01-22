import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {                        
            int def = 1;
            if (map.get(Integer.parseInt(input[i])) != null) {
                map.put(Integer.parseInt(input[i]), map.get(Integer.parseInt(input[i]))+1);
            }
            else {
                map.put(Integer.parseInt(input[i]), def);
            }            
        }

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for (int i=0; i<M; i++) {
            bw.write(map.getOrDefault(Integer.parseInt(input[i]), 0)+" ");
        }
        bw.flush();        
       
        br.close();
        bw.close();        
    }    

}