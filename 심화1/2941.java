package Baekjoon.심화;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        
        int count = 0;

        for (int i=0; i<S.length(); i++) {

            
            if (S.charAt(i) == 'c' && i < S.length() - 1) {
                if (S.charAt(i+1) == '=' || 
                    S.charAt(i+1) == '-') {
                        i++;                        
                }
            }

            else if (S.charAt(i) == 'd') {
                if (i < S.length() - 2 && S.charAt(i+1) == 'z' && S.charAt(i+2) == '=') {
                    i+=2;
                }                     
                else if (i < S.length() - 1 && S.charAt(i+1) == '-') {
                    i++;                        
                }
            }

            else if (i < S.length() - 1 && S.charAt(i) == 'l' && S.charAt(i+1) == 'j') {
                i++;
            }

            else if (i < S.length() - 1 && S.charAt(i) == 'n' && S.charAt(i+1) == 'j') {
                i++;
            }

            else if (i < S.length() - 1 && S.charAt(i) == 's' && S.charAt(i+1) == '=') {
                i++;
            }

            else if (i < S.length() - 1 && S.charAt(i) == 'z' && S.charAt(i+1) == '=') {
                i++;
            }
            count++;
        }

        System.out.print(count);        
        
        sc.close();        

    }
    
}