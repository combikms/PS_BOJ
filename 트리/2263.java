import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void printPreOrder(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder, int inStart, int inEnd,
            int postStart, int postEnd) throws IOException {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }

        int root = postOrder.get(postEnd);
        bw.write(root + " ");

        int leftEnd = inOrder.indexOf(root) - 1;
        int leftSize = leftEnd - inStart + 1;

        printPreOrder(inOrder, postOrder, inStart, leftEnd, postStart, postStart + leftSize - 1);
        printPreOrder(inOrder, postOrder, leftEnd + 2, inEnd, postStart + leftSize, postEnd - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            inOrder.add(Integer.parseInt(input[i]));
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            postOrder.add(Integer.parseInt(input[i]));
        }

        printPreOrder(inOrder, postOrder, 0, n - 1, 0, n - 1);
        bw.flush();

        bw.close();
        br.close();
    }
}