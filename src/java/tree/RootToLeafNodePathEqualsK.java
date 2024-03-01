package tree;

public class RootToLeafNodePathEqualsK {
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

    public Boolean path_sum(BinaryTreeNode root, Integer k) {
        if(root == null) return false;

        return helper(root, k);
    }

    private Boolean helper(BinaryTreeNode root, int k) {
        if(root.left == null && root.right == null) {
            if(k == root.value) return true;
        }

        if(root.left != null) if(helper(root.left, k - root.value)) return true;
        if(root.right != null) if(helper(root.right, k - root.value)) return true;

        return false;
    }
}
