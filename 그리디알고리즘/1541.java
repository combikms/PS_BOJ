import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String[] operands;
        BigInteger sum = BigInteger.ZERO;

        if (!S.contains("-")) {
            operands = S.split("\\+");
            for (int j = 0; j < operands.length; j++) {
                sum = sum.add(new BigInteger(operands[j]));
            }
            bw.write(sum.toString());
            bw.flush();
        } else {
            String[] subtractor = S.split("-");
            String[] firstopernads = subtractor[0].split("\\+");
            int firstnum = 0;
            for (int i = 0; i < firstopernads.length; i++) {
                firstnum += Integer.parseInt(firstopernads[i]);
            }

            BigInteger ans = new BigInteger(Integer.toString(firstnum));
            for (int i = 1; i < subtractor.length; i++) {
                operands = subtractor[i].split("\\+");
                sum = BigInteger.ZERO;
                for (int j = 0; j < operands.length; j++) {
                    sum = sum.add(new BigInteger(operands[j]));
                }
                ans = ans.subtract(sum);
            }
            bw.write(ans.toString());
            bw.flush();
        }

        bw.close();
        br.close();
    }
}
