package Baekjoon.일반수학1;
import java.util.Scanner;

public class Main {

    public static final int Quarter = 25;
    public static final int Dime = 10;
    public static final int Nickel = 5;
    public static final int Penny = 1;
          
    public static void main(String[] args) {        
             
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i=0; i<T; i++) {
            
            int C = sc.nextInt();

            if (C / Quarter > 0) {
                System.out.printf("%d ", C / Quarter);
                C %= Quarter;
            }
            else {
                System.out.printf("%d ", 0);
            }

            if (C / Dime > 0) {
                System.out.printf("%d ", C / Dime);
                C %= Dime;
            }
            else {
                System.out.printf("%d ", 0);
            }

            if (C / Nickel > 0) {
                System.out.printf("%d ", C / Nickel);
                C %= Nickel;
            }
            else {
                System.out.printf("%d ", 0);
            }

            if (C / Penny > 0) {
                System.out.printf("%d\n", C / Penny);
                C %= Penny;
            }
            else {
                System.out.printf("%d\n", 0);
            }

        }
        
        sc.close();
    }
    
}