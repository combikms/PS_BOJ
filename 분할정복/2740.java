import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static int[][] multiply(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int Na = Integer.parseInt(input[0]);
        int Ma = Integer.parseInt(input[1]);

        int[][] A = new int[Na][Ma];
        for (int i = 0; i < Na; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < Ma; j++) {
                A[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");
        int Nb = Integer.parseInt(input[0]);
        int Mb = Integer.parseInt(input[1]);

        int[][] B = new int[Nb][Mb];
        for (int i = 0; i < Nb; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < Mb; j++) {
                B[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] C = multiply(A, B);

        for (int i = 0; i < Na; i++) {
            for (int j = 0; j < Mb; j++) {
                bw.write(C[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }
}