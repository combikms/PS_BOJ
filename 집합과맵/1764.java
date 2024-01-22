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

        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int M = Integer.parseInt(nums[1]);
        Set<String> not_heard = new TreeSet<>();        

        for (int i=0; i<N; i++) {
            not_heard.add(br.readLine());
        }

        int dbj = 0;
        Set<String> dbj_list = new TreeSet<>();

        for (int i=0; i<M; i++) {
            String input = br.readLine();
            if (not_heard.contains(input)) {
                dbj++; dbj_list.add(input);
            }
        }

        bw.write(dbj + "\n");
        for (String dbjob : dbj_list) {
            bw.write(dbjob+"\n");
        }
        bw.flush();        

       
        br.close();
        bw.close();        
    }    

}