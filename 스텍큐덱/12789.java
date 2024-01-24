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
        ArrayList<Integer> people = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            people.add(Integer.parseInt(input[i]));
        }

        int next_number = 1;
        for (int i = 0; i < N; i++) {
            if (people.get(i) == next_number) {
                next_number++;
            } else {
                while (!stack.isEmpty() && stack.get(stack.size() - 1) == next_number) {
                    stack.remove(stack.size() - 1);
                    next_number++;
                }
                stack.add(people.get(i));
            }
        }

        while (!stack.isEmpty() && stack.get(stack.size() - 1) == next_number) {
            stack.remove(stack.size() - 1);
            next_number++;
        }

        if (next_number == N + 1) {
            bw.write("Nice");
        } else {
            bw.write("Sad");
        }
        bw.flush();

        br.close();
        bw.close();
    }

}