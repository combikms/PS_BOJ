package Baekjoon.이차원배열;
import java.util.Scanner;

public class Main {
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);
        
        char[][] mat = new char[5][15];

        for (int i=0; i<5; i++) {
            for (int j=0; j<15; j++) {
                mat[i][j] = '?';
            }
        }

        for (int i=0; i<5; i++) {
            String S = sc.nextLine();
            for (int j=0; j<S.length(); j++) {
                mat[i][j] = S.charAt(j);
            }                        
        }

        for(int j=0; j<15; j++) {
            for(int i=0; i<5; i++) {
                if(mat[i][j] != '?') {
                    System.out.print(mat[i][j]);
                }
            }
        }

        sc.close();        

    }
    
}