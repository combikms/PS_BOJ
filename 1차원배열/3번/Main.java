import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int num = sc.nextInt();
        int target = sc.nextInt();
        

        int array[] = new int[num];

        for (int i=0; i<num; i++) {
            array[i] = sc.nextInt();
        }
        
        for (int i=0; i<num; i++){
            if (array[i] < target){
                System.out.printf("%d ", array[i]);
            }            
        }

        sc.close();
    }    
}