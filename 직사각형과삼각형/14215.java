package Baekjoon.직사각형과삼각형;
import java.util.Scanner;

public class Main {      
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();        

        int c = a1;   int a = a2;   int b = a3;
        if (a2 > c) {
            c = a2; a = a1; b = a3;
        }
        if (a3 > c) {
            c = a3; a = a2; b = a1;
        }
        

        if (a + b > c) {
            System.out.print(a+b+c);
        }
        else {
            while (a + b <= c) {
                c--;
            }
            System.out.print(a+b+c);
        }    

        sc.close();        

    }
    
}