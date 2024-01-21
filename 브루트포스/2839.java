package Baekjoon.브루트포스;
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
        for (int i=N/5; i>=0; i--) {
            for (int j=0; j<=N/3; j++) {
                if (5*i + 3*j == N) {
                    bw.write(i+j+"");
                    bw.flush();
                    br.close();
                    bw.close();
                    return;
                }                
            }
        }
        bw.write("-1");
        bw.flush();
        br.close();
        bw.close();
    }  
}