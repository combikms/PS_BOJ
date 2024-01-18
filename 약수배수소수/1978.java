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

        int N = sc.nextInt();
        int[] inputs = new int[N];
        for (int i=0; i<N; i++) {
            inputs[i] = sc.nextInt();
        }

        int num = 0;
        for (int i=0; i<N; i++) {
            if(isPrime(inputs[i]) == 1) {
                num++;
            }
        }

        System.out.print(num);

        sc.close();        

    }
    
}