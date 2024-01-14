import java.util.Scanner;

public class Main {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int arr[] = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = i+1;            
        }

        for (int a=0; a<m; a++) {

            int i = sc.nextInt();
            int j = sc.nextInt();

            i--;
            j--;

            int arr_temp[] = new int[n];

            int k=j;

            for (int b=i; b<=j; b++) {
                arr_temp[b] = arr[k];
                k--;
            }

            for (int c=i; c<=j; c++) {
                arr[c] = arr_temp[c];
            }

        }

        for (int i=0; i<n; i++) {
            System.out.printf("%d ", arr[i]);
        }

        
        sc.close();
    }    
}
