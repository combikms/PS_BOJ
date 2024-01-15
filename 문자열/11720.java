package Baekjoon.문자열;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();
        String S = sc.nextLine();

        int sum = 0;

        for (int i=0; i<N; i++) {
            sum += S.charAt(i)-48;
        }

        System.out.println(sum);

        sc.close();
        
    }
    
}
