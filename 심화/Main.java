package Baekjoon.심화;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i=0; i<N-1; i++) {            
            System.out.print(" " * (N-1-i));
            System.out.print("*" * (2*(i+1)-1));
            System.out.print("\n");
        }

        System.out.print("*" * (2*N-1));

        for (int i=0; i<N-1; i++) {
            Systme.out.print(" " * (i+1));
            System.out.print("*" * 2*(N-i)-3);
        }
        

        /*
    *           공4 별1
   ***          공3 별3
  *****         공2 별5
 *******        공1 별7
*********       공0 별9
 *******        공1 별7
  *****         공2 별5
   ***          공3 별3
    *           공4 별1
         */
      
        sc.close();

    }
    
}

                // 1 1 2 2 2 8