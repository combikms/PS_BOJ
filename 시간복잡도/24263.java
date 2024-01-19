package Baekjoon.시간복잡도;
import java.util.Scanner;

public class Main {      

    // MenOfPassion(A[], n) {
    //     sum <- 0;
    //     for i <- 1 to n
    //         sum <- sum + A[i]; # 코드1
    //     return sum;
    // }

    // 배열의 첫 번째 원소부터 n번째 원소까지
    // 시그마 한 걸 내놓으시오.
    // O(n)

    public static int time = 0;
    public static int deg = 0;

    public static int MenOfPassion(int A[], int n) {
        int sum = 0;

        deg++;
        for (int i=0; i<n; i++) {
            sum += A[i];    time++;            
        }       
        
        return sum;
    }

    public static void Print_Performance() {
        System.out.println(time);
        System.out.println(deg);
    }
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();        
        int[] A = new int[n];

        int output = MenOfPassion(A, n);

        Print_Performance();

        sc.close();        

    }
    
}