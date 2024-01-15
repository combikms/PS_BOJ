package Baekjoon.문자열;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        String Q = sc.next();
        String R = sc.next();
        String A = "";
        String B = "";

        for (int i=Q.length()-1; i>=0; i--) {
            A += Q.charAt(i);            
        }
        for (int i=R.length()-1; i>=0; i--) {
            B += R.charAt(i);
        }

        int numA = Integer.parseInt(A);
        int numB = Integer.parseInt(B);


        if (numA > numB) {
            System.out.println(numA);
        }        
        else {
            System.out.println(numB);
        }        
        
        sc.close();        
    }
    
}
