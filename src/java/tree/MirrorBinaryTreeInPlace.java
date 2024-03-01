package tree;

public class MirrorBinaryTreeInPlace {
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

    void mirror_image(BinaryTreeNode root) {
        helper(root);

        return;
    }

    private BinaryTreeNode helper(BinaryTreeNode root) {
        // Base Case
        if(root.left == null && root.right == null) return root;

        // Recursive Case
        BinaryTreeNode leftNode = null;
        BinaryTreeNode rightNode = null;

        if(root.left != null) leftNode = helper(root.left);
        if(root.right != null) rightNode = helper(root.right);

        root.left = rightNode;
        root.right = leftNode;

        return root;
    }
}
