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

        String[] input = br.readLine().split(" ");
        int nA = Integer.parseInt(input[0]);
        int nB = Integer.parseInt(input[1]);

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();       

        input = br.readLine().split(" ");
        for (int i=0; i<nA; i++) {
            A.add(Integer.parseInt(input[i]));
        }
        
        input = br.readLine().split(" ");
        for (int i=0; i<nB; i++) {
            B.add(Integer.parseInt(input[i]));
        }

        Set<Integer> A_B = new HashSet<>(A);
        Set<Integer> B_A = new HashSet<>(B);

        A_B.removeAll(B);   B_A.removeAll(A);

        bw.write(A_B.size()+B_A.size()+"");
        bw.flush();
        
       
        br.close();
        bw.close();        
    }    

}