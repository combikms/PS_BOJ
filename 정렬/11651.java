package Baekjoon.정렬;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static class pos {
        int x;
        int y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        pos[] arr = new pos[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            arr[i] = new pos();
            arr[i].x = Integer.parseInt(input[0]);
            arr[i].y = Integer.parseInt(input[1]);                       
        }

        Quick_Sort_Pos(arr, 0, N-1);
        for (pos p : arr) {
            bw.write(p.x + " " + p.y + "\n");
        }        
        bw.flush();

        br.close();
        bw.close();        
    }

    public static void Bubble_Sort_Pos(pos[] arr) {
        for (int i=0; i<arr.length - 1; i++) {
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j].x > arr[j+1].x) {
                    pos temp = new pos();
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                else if (arr[j].x == arr[j+1].x) {
                    if(arr[j].y > arr[j+1].y) {
                        pos temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }
    }
    

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

    public static void Quick_Sort_Pos(pos[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = Partition_Pos(arr, left, right);
            Quick_Sort_Pos(arr, left, pivotIndex - 1);
            Quick_Sort_Pos(arr, pivotIndex + 1, right);
        }
    }
    
    private static int Partition_Pos(pos[] arr, int left, int right) {
        Random rand = new Random();
        int randomIndex = left + rand.nextInt(right - left);        
        
        Swap(arr, randomIndex, right);
    
        pos pivot = arr[right];
        int i = (left - 1);
    
        for (int j = left; j < right; j++) {
            if (arr[j].y < pivot.y || (arr[j].y == pivot.y && arr[j].x < pivot.x)) {
                i++;
                Swap(arr, i, j);
            }
        }
    
        Swap(arr, i + 1, right);
        return i + 1;
    }
    
    private static void Swap(pos[] arr, int i, int j) {
        pos temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void Quick_Sort(int[] arr, int first_index, int last_index) {
        if (first_index < last_index) {
            int pivotIndex = Partition(arr, first_index, last_index);
            Quick_Sort(arr, first_index, pivotIndex - 1);
            Quick_Sort(arr, pivotIndex + 1, last_index);
        }
    }
    
    
    private static int Partition(int[] arr, int first_index, int last_index) {
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

    public static void Counting_Sort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

        int[] count = new int[max+1];
        for (int number : arr) {
            count[number]++;
        }

        for (int i=1; i<count.length; i++) {
            count[i] += count[i-1];
        }

        int[] sorted = new int[arr.length];
        for (int i=arr.length-1; i>=0; i--) {
            sorted[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        System.arraycopy(sorted, 0, arr, 0, arr.length);        
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

}