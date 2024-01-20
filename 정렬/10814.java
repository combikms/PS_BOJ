package Baekjoon.정렬;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final Random rand = new Random();

    public static class person implements Comparable<person>{
        int age;
        String name;

        public int compareTo(person other) {
            return this.age - other.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        person[] list = new person[N];

        for (int i=0; i<N; i++) {
            list[i] = new person();
            String[] input = br.readLine().split(" ");            

            list[i].age = Integer.parseInt(input[0]);
            list[i].name = input[1];
        }

        //이게 타임 정렬이라는 안정적인 정렬 알고리즘인데,
        //나중에 심심하면 공부해보면 좋을 것 같음
        Arrays.sort(list);

        for (int i=0; i<N; i++) {
            bw.write(list[i].age + " " + list[i].name + "\n");
        }
        bw.flush();
        

        br.close();
        bw.close();        
    }    

    public static void Quick_Sort(person[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = Partition(arr, left, right);
            Quick_Sort(arr, left, pivotIndex - 1);
            Quick_Sort(arr, pivotIndex + 1, right);
        }
    }
    
    private static int Partition(person[] arr, int left, int right) {

        int randomIndex = left + rand.nextInt(right - left);
                
        Swap(arr, randomIndex, right);        
    
        person pivot = arr[right];
        int i = (left - 1);
    
        for (int j = left; j < right; j++) {
            if (arr[j].age < pivot.age) {
                i++;
                Swap(arr, i, j);
            }
        }
    
        Swap(arr, i + 1, right);
        return i + 1;
    }

    private static void Swap(person[] arr, int i, int j) {
        person temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 전에 만들어논 함수들 중에 더 이상 쓰잘데기 없는 것들 다 지움


}