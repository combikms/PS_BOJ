import java.util.Scanner;

public class Main {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int arr[] = new int[10];

        for (int i=0; i<10; i++) {
            arr[i] = sc.nextInt();
            arr[i] %= 42;
        }

        for (int j=0; j<9; j++) {
            for (int i=0; i<9; i++) {
                if (arr[i] > arr[i+1]) {
    
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
    
                }
            }
        }

        int count = 1;

        for (int i=0; i<9; i++) {
            if(arr[i] != arr[i+1]) {
                count++;
            }
        }

        System.out.println(count);

        sc.close();
    }    
}
