package Baekjoon.직사각형과삼각형;
import java.util.Scanner;

public class Main {  
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int[] n = new int[4];

        n[0] = h-y;
        n[1] = y;
        n[2] = x;
        n[3] = w-x;

        int min = n[0];
        for (int i=0; i<4; i++) {
            if (min >= n[i]) {
                min = n[i];
            }
        }

        System.out.print(min);
        
        sc.close();        

    }
    
}