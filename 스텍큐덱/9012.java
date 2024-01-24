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

        ArrayList<Character> stack = new ArrayList<>();

        int T = Integer.parseInt(br.readLine());        
        for (int i = 0; i < T; i++) {
            boolean VPS = true;
            String input = br.readLine();
            if (input.charAt(0) == ')') {
                VPS = false;
            } else {
                for (int j = 0; j < input.length(); j++) {
                    if (input.charAt(j) == '(') {
                        stack.add('(');
                    } else {
                        if (stack.isEmpty()) {
                            VPS = false;
                            break;
                        } else {
                            stack.remove(stack.size() - 1);
                        }
                    }
                }
            }
            if (VPS && stack.isEmpty()){
                bw.write("YES" + "\n");
            }                
            else {
                bw.write("NO" + "\n");
            }                
            stack.clear();
        }
        bw.flush();

        br.close();
        bw.close();
    }

}