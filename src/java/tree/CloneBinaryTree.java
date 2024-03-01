package tree;

public class CloneBinaryTree {
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

    static BinaryTreeNode clone_tree(BinaryTreeNode root) {
        // Base Case
        if(root == null) return null;

        // Recursive Case
        BinaryTreeNode newNode = new BinaryTreeNode(root.value);
        newNode.left = clone_tree(root.left);
        newNode.right = clone_tree(root.right);

        return newNode;
    }
}
