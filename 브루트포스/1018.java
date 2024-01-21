package Baekjoon.브루트포스;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Main {   

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); int M = Integer.parseInt(input[1]);
        char[][] original_board = new char[N][M]; 
        
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                original_board[i][j] = line.charAt(j);
            }
        }

        int min = 64;  

        for (int i=0; i<=N-8; i++) {
            for (int j=0; j<=M-8; j++) {
                if (min > Color(original_board, i, j)) {
                    min = Color(original_board, i, j);
                }
            }
        }

        bw.write(min+"");
        bw.flush();      
        
        br.close();
        bw.close();
                   
    }    

    public static int Color(char[][] arr, int i, int j) {

        char[][] white_board = { 
          {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        , {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        , {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        , {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        , {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        , {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        , {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        , {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}        
        };

        char[][] black_board = {
          {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        , {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        , {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        , {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        , {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        , {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        , {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        , {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}  
        };

        int white = 0;  int black = 0;
        for (int x=0; x<8; x++) {
            for (int y=0; y<8; y++) {
                if (arr[i+x][j+y] != white_board[x][y]) {
                    white++;
                }
                if (arr[i+x][j+y] != black_board[x][y]) {
                    black++;
                }
            }
        }               
        if (white < black) {
            return white;
        }
        else {
            return black;
        }
    }
}