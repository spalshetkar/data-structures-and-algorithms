package tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversalBinaryTree {
    private static class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    List<Integer> postorder(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();

        helper(root, result);

        return result;
    }

    private void helper(BinaryTreeNode root, List<Integer> result) {
        if(root == null) return;

        helper(root.left, result);
        helper(root.right, result);
        result.add(root.value);

        return;
    }
}
