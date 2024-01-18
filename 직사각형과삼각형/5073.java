package Baekjoon.직사각형과삼각형;
import java.util.Scanner;

public class Main {      
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        while (true) {

            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            int a3 = sc.nextInt();

            if (a1 == 0 && a2 == 0 && a3 == 0) {
                break;
            }

            int c = a1;   int a = a2;   int b = a3;
            if (a2 > c) {
                c = a2; a = a1; b = a3;
            }
            if (a3 > c) {
                c = a3; a = a2; b = a1;
            }
            

            if (a + b > c) {
                if (a1 == a2 && a2 == a3 && a3 == a1) {
                    System.out.println("Equilateral");
                } else if(a1 != a2 && a2 != a3 && a1 != a3){
                    System.out.println("Scalene");
                } else{
                    System.out.println("Isosceles");
                }
            }
            else {
                System.out.println("Invalid");
            }

        }        

        sc.close();        

    }
    
}