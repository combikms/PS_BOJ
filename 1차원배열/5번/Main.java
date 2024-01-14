import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];

        int i, j, k;

        for (int a=0; a<m; a++){

            i = sc.nextInt();
            j = sc.nextInt();
            k = sc.nextInt();
            
            for (int b = i; b <= j; b++) {
                arr[b-1] = k;
            }

        }

        for (int c=0; c<n; c++) {
            System.out.printf("%d ", arr[c]);
        }
               
        sc.close();
    }    
}
