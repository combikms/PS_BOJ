package Baekjoon.이차원배열;
import java.util.Scanner;

public class Main {
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);
        
        int mat[][] = new int[9][9];
        
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int max = mat[0][0];
        int a=1;
        int b=1;

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (mat[i][j] >= max) {
                    max = mat[i][j];
                    a = i+1;
                    b = j+1;
                }
            }
        }

        System.out.printf("%d\n %d %d", max, a, b);

        sc.close();        

    }
    
}