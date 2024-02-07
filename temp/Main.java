import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input;
        double avg = 0;
        double good_students = 0;
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j < input.length; j++) {
                avg += Integer.parseInt(input[j]);
            }
            avg /= Integer.parseInt(input[0]);
            for (int j = 1; j < input.length; j++) {
                if (Integer.parseInt(input[j]) > avg) {
                    good_students++;
                }
            }
            bw.write((double) good_students / Integer.parseInt(input[0]) * 100 + "%\n");

            avg = 0;
            good_students = 0;
        }

        bw.close();
        br.close();
    }
}