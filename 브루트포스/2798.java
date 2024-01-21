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
        
        String[] input1 = br.readLine().split(" ");

        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);

        int[] cards = new int[N];

        String[] input2 = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            cards[i] = Integer.parseInt(input2[i]);
        }

        int max = 0;
        for (int i=0; i<N-2; i++) {
            for (int j=i+1; j<N-1; j++) {
                for (int k=j+1; k<N; k++) {
                    int val = cards[i] + cards[j] + cards[k];
                    if (val > max && val <= M) {
                        max = val;
                    }
                }
            }
        }

        bw.write(max+"");
        bw.flush();


        br.close();
        bw.close();        
    }    

}