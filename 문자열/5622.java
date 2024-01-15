package Baekjoon.문자열;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
  
        char[][] dial = {
            {'A', 'B', 'C', ' '},
            {'D', 'E', 'F', ' '},
            {'G', 'H', 'I', ' '},
            {'J', 'K', 'L', ' '},
            {'M', 'N', 'O', ' '},
            {'P', 'Q', 'R', 'S'},
            {'T', 'U', 'V', ' '},
            {'W', 'X', 'Y', 'Z'}
        };

        String S = sc.nextLine();
        int time = 0;

        for (int i=0; i<S.length(); i++) {
            for (int j=0; j<8; j++) {
                for (int k=0; k<4; k++) {
                    if (S.charAt(i) == dial[j][k]) {
                        time += j + 3;
                    }
                }
            }
        }

        System.out.println(time);

        sc.close();        
    }
    
}
