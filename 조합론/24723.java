import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static class balloon {
        int number;
        int paper;

        public balloon(int number, int paper) {
            this.number = number;
            this.paper = paper;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write((int) Math.pow(2, N) + "");
        bw.flush();

        bw.close();
        br.close();
    }

}