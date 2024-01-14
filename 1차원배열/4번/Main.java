import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[9];
        
        for (int i=0; i<9; i++){
            arr[i] = sc.nextInt();
        }

        int max = 0;        
        for (int i=0; i<9; i++){
            if (arr[i] > arr[max]) {
                max = i;
            }
        }

        System.out.printf("%d\n%d", arr[max], max+1);

        sc.close();
    }    
}