import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Node root = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(root, data, left, right);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    public static void insertNode(Node node, char data, char left, char right) {

        if (node.data == data) {
            node.lt = (left == '.' ? null : new Node(left, null, null));
            node.rt = (right == '.' ? null : new Node(right, null, null));
        } else {
            if (node.lt != null) insertNode(node.lt, data, left, right);
            if (node.rt != null) insertNode(node.rt, data, left, right);
        }
    }

    public static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data);
        preOrder(node.lt);
        preOrder(node.rt);
    }

    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.lt);
        System.out.print(node.data);
        inOrder(node.rt);
    }

    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.lt);
        postOrder(node.rt);
        System.out.print(node.data);
    }
}

class Node {
    char data;
    Node lt, rt;

    public Node(char data, Node lt, Node rt) {
        this.data = data;
        this.lt = lt;
        this.rt = rt;
    }
}