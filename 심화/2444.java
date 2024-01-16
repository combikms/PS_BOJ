package Baekjoon.심화;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i=0; i<N-1; i++) {

            for (int k=0; k<N-1-i; k++) {
                System.out.print(" ");
            }
            
            for (int k=0; k<(2*(i+1)-1); k++) {
                System.out.print("*");
            }            
            
            System.out.print("\n");
        }


        for (int k=0; k<(2*N-1); k++) {
            System.out.print("*");
        }
        System.out.print("\n");    


        for (int i=0; i<N-1; i++) {

            for (int k=0; k<i+1; k++) {
                System.out.print(" ");
            }

            for (int k=0; k<2*(N-i)-3; k++) {
                System.out.print("*");
            }            
            
            System.out.print("\n");
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