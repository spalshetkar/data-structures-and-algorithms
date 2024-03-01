package tree;

public class LowestCommonAncestor {
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

    public Integer lca(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
        BinaryTreeNode result = helper(root, a, b);

        if(result == null) return 0;

        return result.value;
    }

    private BinaryTreeNode helper(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
        // Base Case
        // Leaf node reached
        if(root == null) return null;

        // If root equals a or b then root will be the lca
        if(root.value == a.value || root.value == b.value) return root;

        // Recursive Case
        // Here a and b have not been found yet so we have to find it in the left and right subtree of root
        BinaryTreeNode leftNode = helper(root.left, a, b);
        BinaryTreeNode rightNode = helper(root.right, a, b);

        // If both nodes are not null that means a and b are in to different subtrees so root will be the lca here
        if(leftNode != null && rightNode != null) return root;

        // If left node is not null but right node is that means both a and b are found in left subtree
        if(leftNode != null) return leftNode;
        // Else a and b are found in right subtree
        else return rightNode;
    }
}
