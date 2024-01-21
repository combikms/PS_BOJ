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

        int number = 666;
        int count = 1;

        int N = Integer.parseInt(br.readLine());

        while (count < N) {
            number++;
            if (String.valueOf(number).contains("666")) {
                count++;
            }            
        }

        bw.write(number+"");
        bw.flush();       
                
        br.close();
        bw.close();                   
    }  

}