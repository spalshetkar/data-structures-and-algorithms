package tree;

public class DiameterBinaryTree {
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

    Integer maxDiameter = 0;
    Integer binary_tree_diameter(BinaryTreeNode root) {
        if(root == null) return 0;

        helper(root);

        return maxDiameter;
    }

    private int helper(BinaryTreeNode root) {
        // Base Case
        if (root.left == null && root.right == null) return 0;

        // Recursive Case
        int leftDiameter = (root.left != null) ? helper(root.left) + 1 : 0;
        int rightDiameter = (root.right != null) ? helper(root.right) + 1 : 0;

        maxDiameter = Math.max(maxDiameter, leftDiameter + rightDiameter);

        return Math.max(leftDiameter, rightDiameter);
    }
}
