package tree;

public class LargestBST {
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

    private static class BSTInfo {
        int min;
        int max;
        int size;
        int maxSize;
        boolean isBst;

        BSTInfo() {
            min = Integer.MIN_VALUE;
            max = Integer.MAX_VALUE;
            size = 0;
            maxSize = 0;
            isBst = true;
        }
    }

    static Integer find_largest_bst(BinaryTreeNode root) {
        BSTInfo result = helper(root);

        return result.maxSize;
    }

    private static BSTInfo helper(BinaryTreeNode root) {
        BSTInfo currNode = new BSTInfo();

        // Base Case
        if(root == null) return currNode;

        // Recursive Case
        // Leaf node
        if(root.left == null && root.right == null) {
            currNode.min = root.value;
            currNode.max = root.value;
            currNode.size = 1;
            currNode.maxSize = 1;
            currNode.isBst = true;
        }
        // Right node
        else if(root.left == null) {
            BSTInfo rightSubTree = helper(root.right);
            // Is a BST
            if(rightSubTree.isBst && root.value <= rightSubTree.min) {
                currNode.min = root.value;
                currNode.max = rightSubTree.max;
                currNode.size = rightSubTree.size + 1;
                currNode.maxSize = Math.max(currNode.size, rightSubTree.maxSize);
                currNode.isBst = true;
            }
            // Is not a BST
            else {
                currNode.maxSize = rightSubTree.maxSize;
                currNode.isBst = false;
            }
        }
        // Left node
        else if(root.right == null) {
            BSTInfo leftSubTree = helper(root.left);
            // Is a BST
            if(leftSubTree.isBst && root.value >= leftSubTree.max) {
                currNode.min = leftSubTree.min;
                currNode.max = root.value;
                currNode.size = leftSubTree.size + 1;
                currNode.maxSize = Math.max(currNode.size, leftSubTree.maxSize);
                currNode.isBst = true;
            }
            // Is not a BST
            else {
                currNode.maxSize = leftSubTree.maxSize;
                currNode.isBst = false;
            }
        }
        // Both nodes
        else {
            BSTInfo leftSubTree = helper(root.left);
            BSTInfo rightSubTree = helper(root.right);
            // Is a BST
            if(leftSubTree.isBst && rightSubTree.isBst && root.value >= leftSubTree.max && root.value <= rightSubTree.min) {
                currNode.min = leftSubTree.min;
                currNode.max = rightSubTree.max;
                currNode.size = leftSubTree.size + rightSubTree.size + 1;
                currNode.maxSize = Math.max(currNode.size, Math.max(leftSubTree.maxSize, rightSubTree.maxSize));
                currNode.isBst = true;
            }
            // Is not a BST
            else {
                currNode.maxSize = Math.max(leftSubTree.maxSize, rightSubTree.maxSize);
                currNode.isBst = false;
            }
        }

        return currNode;
    }
}
