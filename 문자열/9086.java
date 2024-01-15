package Baekjoon.문자열;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        
        for (int i=0; i<T; i++) {
            String S = sc.nextLine();

            System.out.print(S.charAt(0));
            System.out.println(S.charAt(S.length()-1));
        }
        
        sc.close();
        
    }
    
}
