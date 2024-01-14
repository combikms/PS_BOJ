import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int array[] = new int[num];
        
        for (int i=0; i<num; i++) {
            array[i] = sc.nextInt();
        }

        int finder = sc.nextInt();

        int count = 0;
        for (int i=0; i<num; i++) {
            if (array[i] == finder) {
                count++;
            }
        }

        System.out.println(count);

        sc.close();
    }    
}