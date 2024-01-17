package Baekjoon.일반수학1;
import java.util.Scanner;

public class Main {

    public static char convert(int num) {
        if (0 <= num && num <= 9) {           
            return (char)(num + '0');
        }
        else {
            return (char)(num - 10 + 'A');
        }
    }
        
    public static void main(String[] args) {        
             
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int B = sc.nextInt();

        StringBuilder result = new StringBuilder();

        while (N > 0) {

            /*
            
            1. N을 B로 나눈 나머지 구해서 append
            2. N /= B
            3. 또 나머지 구해서 append
            4. N == 0이 될때까지 반복
            5. 역순으로 뒤집으면 제대로 된 결과

             */
            
            // N % B



            result.append(convert(N % B));
            N /= B;

        } 
        
        System.out.print(result.reverse().toString());
        
        sc.close();
    }
    
}