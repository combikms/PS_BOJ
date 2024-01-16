package Baekjoon.심화;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        char[] arr1 = new char[S.length()/2];
        char[] arr2 = new char[S.length()/2];

        for (int i=0; i<S.length()/2; i++) {
            arr1[i] = S.charAt(i);
        }

        int temp = 0;
        for (int j=S.length() - 1; j>= (S.length() - 1) - ((S.length() / 2) - 1 ); j--) {
            arr2[temp] = S.charAt(j);
            temp++;
        }

        if (Arrays.equals(arr1, arr2)) {
            System.out.print(1);
        }
        else {
            System.out.print(0);
        }
      
        sc.close();

    }
    
}