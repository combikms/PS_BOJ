package Baekjoon.직사각형과삼각형;
import java.util.Scanner;

public class Main {  

    public static class pos {
        int x;  int y;
    }
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        pos[] dots = new pos[T];
        for (int i=0; i<T; i++) {
            dots[i] = new pos();
            dots[i].x = 0;  dots[i].y = 0;
        }

        for (int i=0; i<T; i++) {
            dots[i].x = sc.nextInt();
            dots[i].y = sc.nextInt();
        }

        int min_X = dots[0].x;  int max_X = dots[0].x;
        int min_Y = dots[0].y;  int max_Y = dots[0].y;

        for (int i=0; i<T; i++) {
            if (dots[i].x >= max_X){
                max_X = dots[i].x;
            }
            if (dots[i].y >= max_Y){
                max_Y = dots[i].y;
            }
            if (dots[i].x <= min_X){
                min_X = dots[i].x;
            }
            if (dots[i].y <= min_Y){
                min_Y = dots[i].y;
            }
        }

        System.out.print((max_X - min_X) * (max_Y - min_Y));
        
        sc.close();        

    }
    
}