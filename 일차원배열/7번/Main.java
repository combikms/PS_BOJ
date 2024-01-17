import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int arr[] = new int[28];

        for (int i=0; i<28; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i=0; i<30; i++) {
            int exists = 0;
            for (int j=0; j<28; j++) {
                if (i+1 == arr[j]) {
                    exists = 1;
                }
            }
            if (exists == 0) {
                System.out.println(i+1);
            }
        }

        sc.close();
    }    
}
