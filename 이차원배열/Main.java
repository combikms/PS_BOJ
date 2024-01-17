package Baekjoon.이차원배열;
import java.util.Scanner;

public class Main {
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat1 = new int[n][m];
        int[][] mat2 = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                mat2[i][j] = sc.nextInt();
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.printf("%d ", mat1[i][j]+mat2[i][j]);
            }
            System.out.print("\n");
        }


        sc.close();        

    }
    
}