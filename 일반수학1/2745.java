package Baekjoon.일반수학1;
import java.util.Scanner;

public class Main {
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);
        
        String N = sc.next();
        int B = sc.nextInt();

        int num[] = new int[N.length()];
        for (int i=0; i<N.length(); i++) {
            if ('0' <= N.charAt(i) && N.charAt(i) <= '9') {
                num[i] = N.charAt(i) - '0';
            }
            else {
                num[i] = N.charAt(i) - 'A' + 10;
            }
        }

        int sum = 0;
        int k=0;

        for (int j=N.length() - 1; j>=0; j--) {
            sum += Math.pow(B, k) * num[j];
            k++;
        }

        System.out.print(sum);

        sc.close();        

    }
    
}