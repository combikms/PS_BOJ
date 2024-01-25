import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

public class Main {

    public static class Word {
        String word;
        int length;
        int frequency;

        public Word(String word, int length, int frequency) {
            this.word = word;
            this.length = length;
            this.frequency = frequency;
        }

        public int compareTo(Word other) {
            return this.word.compareTo(other.word);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashMap<String, Word> list = new HashMap<>();
        String word;
        for (int i = 0; i < N; i++) {
            word = br.readLine();
            if (word.length() >= M) {
                if (list.containsKey(word)) {
                    Word w = list.get(word);
                    w.frequency++;
                } else {
                    list.put(word, new Word(word, word.length(), 1));
                }
            }
        }

        ArrayList<Word> word_list = new ArrayList<>(list.values());

        word_list.sort((w1, w2) -> {
            if (w1.frequency == w2.frequency) {
                if (w1.length == w2.length) {
                    return w1.word.compareTo(w2.word);
                } else {
                    return w2.length - w1.length;
                }
            } else {
                return w2.frequency - w1.frequency;
            }
        });

        for (Word w : word_list) {
            bw.write(w.word + "\n");
        }

        bw.close();
        br.close();
    }
}