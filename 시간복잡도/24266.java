package Baekjoon.시간복잡도;
import java.util.Scanner;

public class Main {      
   

    public static int time = 0;
    public static int deg = 0;

    public static int MenOfPassion(int A[], int n) {

        int sum = 0;
        deg++;  deg++;  deg++;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    sum += A[i] * A[j] * A[k];  time++;
                }
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

        // int n = sc.nextInt();
        // int[] A = new int[n+1];

        // int output = MenOfPassion(A, n);

        // Print_Performance();

        // 수행 과정은 생략

        long n = sc.nextLong();

        System.out.println(n*n*n);
        System.out.println(3);

       
        sc.close();        

    }
    
}