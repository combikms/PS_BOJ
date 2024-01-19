package Baekjoon.시간복잡도;
import java.util.Scanner;

public class Main {      
   
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        // g(n) = n

        int a1 = sc.nextInt(); //일차항계수
        int a0 = sc.nextInt(); //상수항
        // f(n)

        int c = sc.nextInt();
        // g(n)의 계수
        
        int n0 = sc.nextInt();
        // 이거보다 큰 n에 대하여 f(n) <= cn을
        // 항상 만족하여라.



        // ~ a1 > 0 일 때 ~

        // <판별법>
        // (a1)n + (a0)와 cn의 교점의 x좌표보다
        // n0가 크거나 같으면
        // 참이다.

        // 즉, n0 >= a0 / c-a1일 시 true

        // 그런데! 위는 c > a1인 경우만 생각한 것이다.

        // 만약 c == a1 이라면?!
        // ---> a0가 음수만 아니면 항상 거짓이다

        // 만약 c < a1 이라면?!
        // ---> f(n)이 언젠가는 cn을 압도하기 때문에 항상 거짓

        if (a1 > 0) {
            if (c > a1) {            
                if ((double)n0 >= (double) a0 / (c - a1)) {
                    System.out.println(1);
                } // 참고로 이 값을 double로 정확히 해 줘야
                  // 모든 경우에 대하여 다 맞히는 것임.
                else {
                    System.out.println(0);
                }
            }
            else if (c == a1) {
                if (a0 >= 0) {
                    System.out.println(0);
                }
                else {
                    System.out.println(1);
                }                    
            }
            else {
                System.out.println(0);
            }
        }



        // ~ a1 == 0 일 때 ~

        // 그럼 n0 이상인 n에 대하여
        // a0 <= cn이 항상 참이어야 한다는 것이므로
        // n0 >= a0 / c 가 되어야 참이다.

        else if (a1 == 0) {
            if ((double)n0 >= (double)a0 / c) {                
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }      



        // ~ a1 < 0 일 떄 ~
        // a1이 양수인 경우에서 c가 a1보다 큰 경우와 동일
        // 즉, n0가 교점의 x좌표보다 크면 된다는 말.

        else {
            if ((double)n0 >= (double) a0 / (c - a1)) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
        



        
        sc.close();   

        
        // 진짜 이거 한 번에 맞히는 사람 있을까 ㅋㅋ

    }
    
}