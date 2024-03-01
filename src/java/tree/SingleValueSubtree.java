package tree;

public class SingleValueSubtree {
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

    Integer count = 0;
    public Integer find_single_value_trees(BinaryTreeNode root) {
        if(root == null) return 0;

        helper(root);

        return count;
    }

    private boolean helper(BinaryTreeNode root) {
        // Base Case
        if(root.left == null && root.right == null) {
            count++;
            return true;
        }

        // Recursive Case
        boolean uVal = true;

        if(root.left != null) uVal = (helper(root.left) && (root.value == root.left.value));
        if(root.right != null) uVal = (helper(root.right) && (root.value == root.right.value)) && uVal;

        if(uVal) {
            count++;
            return true;
        }

        return false;
    }
}
