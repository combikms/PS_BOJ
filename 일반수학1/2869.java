package Baekjoon.일반수학1;
import java.util.Scanner;

public class Main {
    
    public static int f(int A, int B, int V) {
        
        return ((V - B - 1) / (A - B)) + 1;
    }
   
    public static void main(String[] args) { 
        
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        System.out.print(f(A, B, V));

        sc.close();                    
        
    }
    
}
