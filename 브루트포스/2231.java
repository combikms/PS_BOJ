package Baekjoon.브루트포스;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Main {   

    public static int Sum(String N) {
        int result = 0;
        result += Integer.parseInt(N);

        for (int i=0; i<N.length(); i++) {
            result += (int)(N.charAt(i) - '0');
        }
        
        return result;        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String N = br.readLine();

        int i=1;
        int M=0;
        while (i<=Integer.parseInt(N)) {
            if (Sum(Integer.toString(i)) == Integer.parseInt(N)) {
                M = i;                
                break;
            }
            i++;            
        }

        bw.write(M+"");
        bw.flush();

        br.close();
        bw.close();        
    }    

}