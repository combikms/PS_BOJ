import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.io.IOException;


public class Main {   

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        HashSet<Integer> set = new HashSet<>();

        for (int i=0; i<size; i++) {
            set.add(Integer.parseInt(input[i]));
        }

        int cards_size = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");
        for (int i=0; i<cards_size; i++) {
            if (set.contains(Integer.parseInt(cards[i]))) {
                bw.write(1+" ");
            }
            else {
                bw.write(0+" ");
            }
        }
        bw.flush();
       
        br.close();
        bw.close();        
    }    

}