import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.io.IOException;


public class Main {   

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>(Comparator.reverseOrder());
        for (int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            if ((input[1]).equals("enter")) {
                 set.add(input[0]);
            }
            else if ((input[1]).equals("leave")) {
                set.remove(input[0]);
            }
        }

        for (String people : set) {
            bw.write(people + "\n");
        }
        bw.flush();
       
        br.close();
        bw.close();        
    }    

}