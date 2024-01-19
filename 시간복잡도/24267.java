package Baekjoon.시간복잡도;
import java.util.Scanner;

public class Main {      
   

    public static int time = 0;
    public static int deg = 0;

    public static int MenOfPassion(int A[], int n) {

        int sum = 0;
        deg++;  deg++;  deg++;
        for (int i=1; i<= n-2; i++) {
            for (int j=i+1; j<=n-1; j++) {
                for (int k=j+1; k<=n; k++) {
                    sum += A[i] * A[j] * A[k];  time++;
                }// n-j번
            }// n-i-1번            
        }//n-2번  ---> 이렇게 하면 머리 터진다.

        // 이 문제는 조합론적 접근법으로 쉽게 이해할 수 있다.
        // 여기 n개의 공이 있다고 가정을 해보자.
        //
        // OOOOO ... OOOO
        //
        // 위 반복문 인자의 스타팅과 끝을 봐라.
        // 공을 세 개씩 뽑아서 그 공 번호들을 다 곱한 값을
        // sum에 적재하고 있다.
        //
        // 그 모든 경우의 수가 nC3 아닌가? ㅋㅋ
        // 역시 머리가 나쁘면 몸이 고생한다.
        //
        // 그래서 결론은 n(n-1)(n-2) / 6

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

        // 역시나 수행과정은 생략

        long n = sc.nextLong();        

        //nC3
        System.out.println(n * (n-1) * (n-2) / 6);
        System.out.println(3);

        
        sc.close();        

    }
    
}