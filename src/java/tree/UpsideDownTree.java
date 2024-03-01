package tree;

public class UpsideDownTree {
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

    public BinaryTreeNode flip_upside_down(BinaryTreeNode root) {
        // Base Case
        if (root == null || (root.left == null && root.right == null)) return root;

        // Recursive Case
        BinaryTreeNode node = flip_upside_down(root.left);
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return node;
    }
}
