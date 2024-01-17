package Baekjoon.이차원배열;
import java.util.Scanner;

public class Main {
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int[][] paper = new int[100][100];
        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                paper[i][j] = 0;
            }
        }

        for (int i=0; i<T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            a--;
            b--;

            for (int j=a; j<a+10; j++) {
                for (int k=b; k<b+10; k++) {
                    paper[j][k] = 1;
                }
            }
        }

        int S = 0;
        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                if (paper[i][j] == 1) {
                    S++;
                }
            }
        }

        System.out.print(S);

        sc.close();        

    }
    
}