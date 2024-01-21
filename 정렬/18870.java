package Baekjoon.정렬;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    private static final Random rand = new Random();

    public static class pos {
        int value;
        int index;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        pos[] arr = new pos[N];
                
        String[] inputs = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            arr[i] = new pos();
            arr[i].value = Integer.parseInt(inputs[i]);
            arr[i].index = i;
        }

        // Quick_Sort(arr, 0, N-1); 얘보다 라이브러리 함수가 쫌 더 낫다고 함
        Arrays.sort(arr, new Comparator<pos>() {
        public int compare(pos p1, pos p2) {
            return Integer.compare(p1.value, p2.value);
        }
        });

        Compress(arr);   

        int[] result = new int[N];
        for (int i=0; i<N; i++) {
            result[arr[i].index] = arr[i].value;
        }

        //Quick_Restore(arr, 0, N-1); (이거하면 logn배 더 걸림)

        for (int i=0; i<N; i++) {
            bw.write(result[i]+" ");
        }

        bw.flush();
        
        br.close();
        bw.close();        
    }    

    public static void Compress(pos[] arr) {
        int val = 0;
        for (int i=0; i<arr.length; i++) {
            while (i+1 < arr.length && arr[i].value == arr[i+1].value) {
                arr[i].value = val;
                i++;
            }       
            arr[i].value = val;                 
            val++;
        }
    }

    public static void Quick_Sort(pos[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = Partition(arr, left, right);
            Quick_Sort(arr, left, pivotIndex - 1);
            Quick_Sort(arr, pivotIndex + 1, right);
        }
    }

    public static void Quick_Restore(pos[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = Restore(arr, left, right);
            Quick_Restore(arr, left, pivotIndex - 1);
            Quick_Restore(arr, pivotIndex + 1, right);
        }
    }

    private static int Restore(pos[] arr, int left, int right) {

        int randomIndex = left + rand.nextInt(right - left);
                
        Swap(arr, randomIndex, right);        
    
        pos pivot = arr[right];
        int i = (left - 1);
    
        for (int j = left; j < right; j++) {
            if (arr[j].index < pivot.index) {
                i++;
                Swap(arr, i, j);
            }
        }
    
        Swap(arr, i + 1, right);
        return i + 1;
    }
    
    
    private static int Partition(pos[] arr, int left, int right) {

        int randomIndex = left + rand.nextInt(right - left);
                
        Swap(arr, randomIndex, right);        
    
        pos pivot = arr[right];
        int i = (left - 1);
    
        for (int j = left; j < right; j++) {
            if (arr[j].value < pivot.value) {
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

    // 전에 만들어논 함수들 중에 더 이상 쓰잘데기 없는 것들 다 지움


}