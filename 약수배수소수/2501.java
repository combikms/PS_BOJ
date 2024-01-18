package Baekjoon.약수배수소수;
import java.util.Scanner;

public class Main {
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);
       
        int N = sc.nextInt();
        int k = sc.nextInt();

        int[] factors = new int[N];
        for (int i=0; i<N; i++) {
            factors[i] = 0;
        }

        int j=0;

        for (int i=1; i<=N; i++){
            if (N % i == 0) {
                factors[j] = i;
                j++;
            }
        }

        System.out.println(factors[k-1]); 

        sc.close();        

    }
    
}