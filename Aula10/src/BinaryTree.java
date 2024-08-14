import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    TreeNode root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }
    public List<Integer> inorderTraversal() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalRec(root, list);
        return list;
    }

    private void inorderTraversalRec(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorderTraversalRec(root.left, list);
            list.add(root.value);
            inorderTraversalRec(root.right, list);
        }
    }

    public void buildBalancedTree() {
        List<Integer> nodes = inorderTraversal();
        root = buildBalancedTree(nodes);
    }

    private TreeNode buildBalancedTree(List<Integer> nodes) {
        if (nodes.isEmpty()) return null;
        return buildBalancedTreeRec(nodes, 0, nodes.size() - 1);
    }

    private TreeNode buildBalancedTreeRec(List<Integer> nodes, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nodes.get(mid));
        node.left = buildBalancedTreeRec(nodes, start, mid - 1);
        node.right = buildBalancedTreeRec(nodes, mid + 1, end);
        return node;
    }

    public void printInOrder() {
        List<Integer> sortedList = inorderTraversal();
        System.out.println("Números em ordem crescente:");
        for (int value : sortedList) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public void printTree(String message) {
        System.out.println(message);
        printTreeRec(root, "", true);
    }

    private void printTreeRec(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.value);
            printTreeRec(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTreeRec(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}
