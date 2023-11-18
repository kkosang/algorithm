import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [#1] 이진트리순회(DFS)
 * */
public class No7_05 {
    Node root;

    public static void main(String args[]) throws IOException {
        No7_05 tree = new No7_05();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }

    public void DFS(Node root) {
        if (root == null) return; // 리프노드
        else {
            /*System.out.print(root.data + " "); 전위순회*/
            DFS(root.lt); // 왼쪽자식
            /*System.out.print(root.data + " "); 중위순회*/
            DFS(root.rt); // 오른쪽자식
            /*System.out.print(root.data + " "); 후위순회*/
        }
    }

    static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }
}


