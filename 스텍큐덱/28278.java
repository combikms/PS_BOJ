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

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {

            String[] input = br.readLine().split(" ");

            switch (Integer.parseInt(input[0])) {
                case 1:
                    stack.add(Integer.parseInt(input[1]));
                    break;

                case 2:
                    if (stack.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(stack.get(stack.size() - 1) + "\n");
                        stack.remove(stack.size() - 1);
                    }
                    break;

                case 3:
                    bw.write(stack.size() + "\n");
                    break;

                case 4:
                    if (stack.isEmpty()) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }

                    break;

                case 5:
                    if (stack.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(stack.get(stack.size() - 1) + "\n");                        
                    }

                    break;

                default:
                    return;
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }

}