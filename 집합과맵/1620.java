import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
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

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, Integer> map = new LinkedHashMap<>();
        Map<Integer, String> map2 = new LinkedHashMap<>();
        for (int i=0; i<N; i++) {
            String name = br.readLine();
            map.put(name, i+1);
            map2.put(i+1, name);
        }

        for (int i=0; i<M; i++) {
            String question = br.readLine();
            try {
                int number = Integer.parseInt(question);
                bw.write(map2.get(number)+"\n");

            } catch (NumberFormatException e) {                
                bw.write(map.get(question)+ "\n");
            }
        }
        bw.flush();
        
       
        br.close();
        bw.close();        
    }    

}