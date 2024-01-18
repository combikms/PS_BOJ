package Baekjoon.직사각형과삼각형;
import java.util.Scanner;

public class Main {      
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();

        if (a1 + a2 + a3 == 180) {
            if (a1 == a2 && a2 == a3 && a3 == a1) {
                System.out.println("Equilateral");
            } else if(a1 != a2 && a2 != a3 && a1 != a3){
                System.out.println("Scalene");
            } else{
                System.out.println("Isosceles");
            }
        }
        else {
            System.out.println("Error");
        }

        

        sc.close();        

    }
    
}