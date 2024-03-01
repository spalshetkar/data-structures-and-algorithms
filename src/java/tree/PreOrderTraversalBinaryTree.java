package tree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversalBinaryTree {
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

    List<Integer> preorder(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();

        helper(root, result);

        return result;
    }

    private void helper(BinaryTreeNode root, List<Integer> result) {
        if(root == null) return;

        result.add(root.value);
        helper(root.left, result);
        helper(root.right, result);

        return;
    }
}
