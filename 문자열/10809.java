package Baekjoon.문자열;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        String S = sc.nextLine();
        int arr[] = new int[26];

        for (int i=0; i<26; i++) {
            arr[i] = -1;
        }

        for (int i=0; i<S.length(); i++) {
            char currentchar = S.charAt(i);
            for (int j=0; j<26; j++) {
                if (j == currentchar - 'a') {
                    if (arr[j] == -1){                        
                        arr[j] = i;
                    }
                }
            }
        }

        for (int i=0; i<26; i++) {
            
            System.out.printf("%d ", arr[i]);

        }

        sc.close();
        
    }
    
}
