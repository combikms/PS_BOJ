package Baekjoon.시간복잡도;
import java.util.Scanner;

public class Main {      
   

    public static int time = 0;
    public static int deg = 0;

    public static int MenOfPassion(int A[], int n) {

        int sum = 0;
        deg++;  deg++;
        for (int i=1; i<=n-1; i++) {
            for (int j=i+1; j<=n; j++) {
                sum += A[i] * A[j]; time++;
            } // n-i번 수행
        } // n-1번 수행

        return sum;
    }

    // (n-1) + (n-2) + ... + 2 + 1 == n(n-1)/2

    public static void Print_Performance() {
        System.out.println(time);
        System.out.println(deg);
    }
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        // int n = sc.nextInt();
        // int[] A = new int[n+1];

        // int output = MenOfPassion(A, n);

        // Print_Performance();

        // 이 문제도 마찬가지..

        long n = sc.nextLong();

        System.out.println(n*(n-1)/2);
        System.out.println(2);
        
        sc.close();        

    }
    
}