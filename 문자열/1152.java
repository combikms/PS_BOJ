package Baekjoon.문자열;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        String S = sc.nextLine().trim();
        int count = 0;
        
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) == ' ') {
                count++;                
            }            
        }   
        
        if (S.isEmpty()) {
            System.out.println(0);
        }
        else {          
            System.out.println(count+1);
        }
        sc.close();        
    }
    
}
