package Baekjoon.약수배수소수;
import java.util.Scanner;

public class Main {  

    public static int isPrime(int k) {
        if (k <= 1) {
            return 0;
        }
        else {
            for (int i=2; i*i<=k; i++){
                if (k % i == 0) {
                    return 0;
                }
            }
            return 1;
        }
    }
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int i=2;
        while (i<=Math.sqrt(N)) {
            if (isPrime(i) == 1) {
                while (N % i == 0){
                    System.out.println(i);
                    N /= i;
                }                               
            }                
            i++;        
        }
        if (N>1) {
            System.out.println(N);
        }
        
        sc.close();        

    }
    
}