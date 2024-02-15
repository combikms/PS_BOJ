import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void preToPost(ArrayList<Integer> tree, int start, int end) throws IOException {
        if (start > end) {
            return;
        }

        int root = tree.get(start);

        int right;
        for (right = start + 1; right <= end; right++) {
            if (tree.get(right) > root) {
                break;
            }
        }

        preToPost(tree, start + 1, right - 1);
        preToPost(tree, right, end);

        bw.write(root + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> tree = new ArrayList<>();
        String S;

        while ((S = br.readLine()) != null) {
            tree.add(Integer.parseInt(S));
        }

        preToPost(tree, 0, tree.size() - 1);
        bw.flush();

        bw.close();
        br.close();
    }
}