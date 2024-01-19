package Baekjoon.시간복잡도;
import java.util.Scanner;

public class Main {      

    // MenOfPassion(A[], n) {
    //     sum <- 0;
    //     for i <- 1 to n
    //         for j <- 1 to n
    //             sum <- sum + A[i] × A[j]; # 코드1
    //     return sum;
    // }

    // 1 * (1+2+...+n)
    // 2 * (1+2+...+n)
    // 3 * (1+2+...+n)
    // ...
    // n * (1+2+...+n)
    // == (1+2+...n) * (1+2+...+n) >> 시그마의 제곱
    
    // O(n^2)

    public static long time = 0;
    public static int deg = 0;

    public static long MenOfPassion(long A[], long n) {
        
        long sum = 0;

        deg++;  deg++;
        for (int i=0; i<n; i++) {            
            for (int j=0; j<n; j++) {
                sum += A[i]*A[j];   time++;
            }
        }

        return sum;
    }

    public static void Print_Performance() {
        System.out.println(time);
        System.out.println(deg);
    }
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();        
        //long[] A = new long[n];

        // for (int i=0; i<n; i++) {
        //    A[i] = 0;
        // }

        // long output = MenOfPassion(A, n);

        // Print_Performance();

        // 알고리즘을 실제로 실행하는 부분을 포함하면
        // 시간초과가 떠서 생략..;

        System.out.println(n*n);
        System.out.println(2);

        sc.close();        

    }
    
}