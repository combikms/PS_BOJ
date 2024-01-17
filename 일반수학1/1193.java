package Baekjoon.일반수학1;
import java.util.Scanner;

public class Main {

    // x와 y를 배열로 반환
    public static int[] move_right(int x, int y) {
        return new int[]{x + 1, y};
    }

    public static int[] move_left_down(int x, int y) {
        return new int[]{x - 1, y + 1};     
    }

    public static int[] move_down(int x, int y) {
        return new int[]{x, y + 1};       
    }

    public static int[] move_right_up(int x, int y) {
        return new int[]{x + 1, y - 1};       
    }

    public static void f(int a) {
        
        int x = 1;
        int y = 1;
        int[] pos;

        if(a == 1) {
            System.out.printf("%d/%d", y, x);
            return;
        }
        else {
            while (a > 1) {
                pos = move_right(x, y); x = pos[0]; y = pos[1]; a--;
                while(a > 1 && x > 1) {
                    pos = move_left_down(x, y); x = pos[0]; y = pos[1]; a--;
                }
                if (a <= 1) {
                    break;
                }
                pos = move_down(x, y); x = pos[0]; y = pos[1]; a--;
                if (a <= 1) {
                    break;
                }
                while(a > 1 && y > 1) {
                    pos = move_right_up(x, y); x = pos[0]; y = pos[1]; a--;
                }
            }            

            System.out.printf("%d/%d", y, x);
            return;       
        }
        
    }
   
    public static void main(String[] args) {        
             
        Scanner sc = new Scanner(System.in);      

        int a = sc.nextInt();
        f(a);     
              
        sc.close();
    }
    
}
