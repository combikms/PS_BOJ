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
        
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]); int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]); int d = Integer.parseInt(input[3]);
        int e = Integer.parseInt(input[4]); int f = Integer.parseInt(input[5]);
        
        int x = -999, y = -999;
        for (x = -999; x <= 999; x++) {
            for (y = -999; y <= 999; y++) {
                if (a*x + b*y == c && d*x + e*y == f) {
                    bw.write(x + " " + y);
                    bw.flush();
                    br.close();
                    bw.close();
                    return;
                }
            }
        }              
    }    

}