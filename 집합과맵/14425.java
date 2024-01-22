import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.io.IOException;


public class Main {   

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();

        String[] nums = br.readLine().split(" ");
        for (int i=0; i<Integer.parseInt(nums[0]); i++) {
            set.add(br.readLine());
        }
        int count = 0;
        for (int i=0; i<Integer.parseInt(nums[1]); i++) {
            if (set.contains(br.readLine())) {
                count++;
            }
        }
        bw.write(count+"");
        bw.flush();
        
       
        br.close();
        bw.close();        
    }    

}