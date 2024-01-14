import java.util.Scanner;

public class Main {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double arr[] = new double[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextDouble();
        }

        double max = arr[0];
        for (int i=0; i<n; i++) {
            if(max <= arr[i]){
                max = arr[i];
            }
        }

        for (int i=0; i<n; i++) {
            arr[i] = ( arr[i] / max ) * 100;
        }

        double average = 0;
        for (int i=0; i<n; i++) {
            average += arr[i];
        }
        average /= n;

        System.out.println(average);
        
        sc.close();
    }    
}
