package Baekjoon.일반수학1;
import java.util.Scanner;

public class Main {

    public static int f(int x) {

        if (x == 1) {
            return 1;
        }
        else {

            x-=1;
            int i=1;
            while (x>0) {
                x -= 6*i;
                i++;
            }

            return i;            
        }

    }
   
    public static void main(String[] args) {        
             
        Scanner sc = new Scanner(System.in);

        /*
         * 1
         * 6*1
         * 6*2
         * 6*3
         * 6*4
         */

        int x = sc.nextInt();
        System.out.print(f(x));       
              
        sc.close();
    }
    
}