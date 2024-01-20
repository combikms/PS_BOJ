package Baekjoon.정렬;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Random;

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

    public static void Quick_Sort(int[] arr, int first_index, int last_index) {
        if (first_index < last_index) {
            int pivotIndex = partition(arr, first_index, last_index);
            Quick_Sort(arr, first_index, pivotIndex - 1);
            Quick_Sort(arr, pivotIndex + 1, last_index);
        }
    }
    
    private static int partition(int[] arr, int first_index, int last_index) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt((last_index - first_index)+1)+first_index;
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[first_index];
        arr[first_index] = temp;
        
        int pivot = arr[first_index];
        int i = first_index + 1;
    
        for (int j = i; j <= last_index; j++) {
            if (arr[j] < pivot) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
    
        arr[first_index] = arr[i - 1];
        arr[i - 1] = pivot;
        return i - 1;
    }
    

    public static void Print_All(int[] arr) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
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
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Quick_Sort(arr, 0, N-1);
        Print_All(arr);

        br.close();        
    }
    
}