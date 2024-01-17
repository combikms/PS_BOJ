package Baekjoon.심화;
import java.util.Scanner;

public class Main {

    public static int check_group_word(String S) {

        for (int i=0; i<S.length(); i++) {

            if (i<S.length()-1) {
                while (S.charAt(i) == S.charAt(i+1)) {
                    i++;
                    if (i == S.length()-1) {
                        break;
                    }                    
                }
            }

            if (i != S.length()-1) {
                for (int j=i; j<S.length(); j++) {
                    if (S.charAt(i) == S.charAt(j)){
                        if (j-i > 1) {
                            return 0;
                        }
                    }
                }
            }                     
        }

        return 1;
    }
    
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        int count = 0;

        for (int i=0; i<T; i++) {
            String S = sc.nextLine();

            if (check_group_word(S) == 1) {
                count++;
            }            
        }

        System.out.print(count);

        sc.close();        

    }
    
}