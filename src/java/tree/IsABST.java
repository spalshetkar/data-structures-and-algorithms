package tree;

public class IsABST {
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

    public Boolean is_bst(BinaryTreeNode root) {
        if(root == null) return true;

        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(BinaryTreeNode root, long min, long max) {
        // Base Case
        if(root.value < min || root.value > max) return false;

        // Recursive Case
        boolean isLeftBst = false;
        boolean isRightBst = false;

        if(root.left != null) isLeftBst = helper(root.left, min, root.value);
        else isLeftBst = true;

        if(root.right != null) isRightBst = helper(root.right, root.value, max);
        else isRightBst = true;

        return isLeftBst && isRightBst;
    }
}
