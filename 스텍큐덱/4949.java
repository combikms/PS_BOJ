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

        String line;
        while (!(line = br.readLine()).equals(".")) {
            boolean VPS = true;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '(') {
                    stack.add('(');
                } else if (line.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        VPS = false;
                        break;
                    } else {
                        if (stack.get(stack.size() - 1) != '(') {
                            VPS = false;
                            break;
                        } else {
                            stack.remove(stack.size() - 1);
                        }
                    }
                } else if (line.charAt(i) == '[') {
                    stack.add('[');
                } else if (line.charAt(i) == ']') {
                    if (stack.isEmpty()) {
                        VPS = false;
                        break;
                    } else {
                        if (stack.get(stack.size() - 1) != '[') {
                            VPS = false;
                            break;
                        } else {
                            stack.remove(stack.size() - 1);
                        }
                    }
                }
            }

            if (!stack.isEmpty()) {
                VPS = false;
            }

            if (VPS) {
                bw.write("yes"+"\n");
            } else {
                bw.write("no"+"\n");
            }
            
            // if (VPS && stack.isEmpty()) {
            //     bw.write("yes" + "\n");
            // } else {
            //     bw.write("no" + "\n");
            // } 원래 코드

            stack.clear();
        }
        bw.flush();

        br.close();
        bw.close();
    }

}