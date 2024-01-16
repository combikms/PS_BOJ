package Baekjoon.심화;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        
        int arr[] = new int[S.length()];       
        for (int i=0; i<S.length(); i++) {
            arr[i] = S.charAt(i) % 32 - 1; // A==a==0
        }

        int alphabet[] = new int[26];
        for (int i=0; i<26; i++) {
            alphabet[i] = 0;
        }
        for (int i=0; i<arr.length; i++) {
            alphabet[arr[i]]++;
        }     

        int max = alphabet[0];
        int temp = 0;
        for (int i=0; i<26; i++) {
            if (max < alphabet[i]){
                max = alphabet[i];
                temp = i;
            }
        }

        char answer = (char)(temp+65);
        
        for (int i=temp+1; i<26; i++) {
            if (alphabet[i] == alphabet[temp]) {                
                answer = '?';
            }            
        }         

                        
        System.out.print(answer); 

              
        sc.close();        

    }
    
}