package Baekjoon.약수배수소수;
import java.util.Scanner;

public class Main {

    public static int perfect(int N, int[] factors) {
        int sum = 0;
        for (int i=0; i<factors.length; i++) {
            sum += factors[i];
        }
        sum -= N;
        if (sum == N) {
            return 1;
        }
        else {
            return 0;
        }        
    }
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        while (true) {       
       
            int N = sc.nextInt();           

            if (N == -1) {
                break;
            }

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
            
            if (perfect(N, factors) == 1) {
                System.out.printf("%d = ", N);
                int i=0;
                while (factors[i] != 0) {
                    System.out.printf("%d", factors[i]);
                    if (factors[i+1] == N) {
                        break;
                    }
                    else {
                        System.out.printf(" + ");
                    }
                    i++;
                }
                System.out.print("\n");

            }
            else {
                System.out.printf("%d is NOT perfect.\n", N);
            }
        }

        sc.close();        

    }
    
}