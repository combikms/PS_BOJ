package Baekjoon.약수배수소수;
import java.util.Scanner;

public class Main {  

    public static int isPrime(int k) {
        int factors=0;         
        for (int i=1; i<=k; i++) {
            if (k % i == 0) {
                factors++;
            }            
        }
        if (factors == 2) {
            return 1;
        }
        else {
            return 0;
        }
    }
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        int min = sc.nextInt();
        int max = sc.nextInt();
        int length = max - min + 1;

        int[] factors = new int[length];
        for (int i=0; i<length; i++) {
            factors[i] = 0;
        }

        int j=0;
        for (int i=min; i<=max; i++) {
            if (isPrime(i) == 1) {
                factors[j] = i;
                j++;
            }            
        }

        int sum = 0;
        for (int i=0; i<length; i++) {
            sum+=factors[i];
        }

        if (sum == 0) {
            System.out.print(-1);
        }
        else {
            System.out.printf("%d\n%d", sum, factors[0]);
        }

        
        sc.close();        

    }
    
}