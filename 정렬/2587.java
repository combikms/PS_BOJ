package Baekjoon.정렬;
import java.util.Scanner;

public class Main {

    public static void Bubble_Sort(int[] arr) {        
        for (int i=0; i<arr.length - 1; i++) {
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }                
            }
        }
    }

    public static void Print_All(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }        
    }

    public static int Average(int[] arr) {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public static int Middle(int[] arr) {
        return arr[arr.length/2];
    }
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        for (int i=0; i<5; i++) {
            arr[i] = 0;
        }

        for (int i=0; i<5; i++) {
            arr[i] = sc.nextInt();
        }

        Bubble_Sort(arr);        
        System.out.println(Average(arr));
        System.out.println(Middle(arr));
          

        sc.close();        

    }
    
}