import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> stack = new ArrayList<>();

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {

            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                if (!stack.isEmpty()) {
                    stack.remove(stack.size()-1);
                }                

            } else {
                stack.add(n);
            }           
            
        }

        int sum = 0;
        for (int i=0; i<stack.size(); i++) {
            sum+=stack.get(i);
        }
        bw.write(sum+"");
        bw.flush();

        br.close();
        bw.close();
    }

}