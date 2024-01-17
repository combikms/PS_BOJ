package Baekjoon.일반수학1;
import java.util.Scanner;

public class Main {

    public static int dots(int x) {
        // 2 + Sigma 2^(x-1)
        int result = 2;
        for (int i=0; i<x; i++) {
            result += (int)Math.pow(2, i);
        }
        return result * result;
    }

    public static void main(String[] args) {        
             
        Scanner sc = new Scanner(System.in);
        
        /*
         * 2
         * 
         * 2 + 1
         * 2 + 1 + 2
         * 2 + 1 + 2 + 4
         * 2 + 1 + 2 + 4 + 8
         * 2 + 1 + 2 + 4 + 8 + 16
         * 
         */

        int input = sc.nextInt();
        System.out.print(dots(input));

        
        sc.close();
    }
    
}