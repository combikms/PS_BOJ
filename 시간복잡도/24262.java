package Baekjoon.시간복잡도;
import java.util.Scanner;

public class Main {      

    // MenOfPassion(A[], n) {
    //     i = ⌊n / 2⌋;
    //     return A[i]; # 코드1
    // }

    // 배열의 반번째 원소를 찾아주시오
    // >> 1회 시행, O(1)

    public static int time = 0;
    public static int deg = 0;

    public static int MenOfPassion(int A[], int n) {
        int i = n / 2;
        
        time++;
        return A[i];
    }
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();        
        int[] A = new int[n];

        int output = MenOfPassion(A, n);

        System.out.println(time);
        System.out.println(deg);

        sc.close();        

    }
    
}