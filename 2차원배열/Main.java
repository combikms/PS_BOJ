package Baekjoon.2차원배열;
import java.util.Scanner;

public class Main {

    public static class form {

        String subj;
        Double hakj;
        Double score;

    }    

    public static double convert(String s) {
        switch (s) {
            case "A+": return 4.5;
            case "A0": return 4.0;
            case "B+": return 3.5;
            case "B0": return 3.0;
            case "C+": return 2.5;
            case "C0": return 2.0;
            case "D+": return 1.5;
            case "D0": return 1.0;
            case "F":  return 0.0;
            default:   return -1;
        }
    }
        
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);
        form[] list = new form[20];

        double boonja = 0;
        double boonmo = 0;
        

        for (int i=0; i<20; i++) {

            list[i] = new form();

            String subj = sc.next();
            double hakj = sc.nextDouble();
            String score = sc.next();

            list[i].subj = subj;
            list[i].hakj = hakj;
            list[i].score = convert(score);

            if (!"P".equals(score)) {                
                boonja += list[i].hakj * list[i].score;
                boonmo += list[i].hakj;
            }
        }

        System.out.print(boonja/boonmo);        

        sc.close();        

    }
    
}