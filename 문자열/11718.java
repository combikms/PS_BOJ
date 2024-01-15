package Baekjoon.문자열;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);        
        char[][] S = new char[100][];

        int i = 0;
  
        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            S[i] = input.toCharArray();
            i++;
        }

        for (int j=0; j<i; j++) {
            for (int k=0; k<S[j].length; k++) {
                System.out.print(S[j][k]);
            }
            System.out.print("\n");
        }
        

        sc.close();        
    }
    
}
