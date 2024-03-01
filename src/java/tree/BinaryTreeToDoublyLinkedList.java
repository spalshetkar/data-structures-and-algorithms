package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeToDoublyLinkedList {
    class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public BinaryTreeNode binary_tree_to_cdll(BinaryTreeNode root) {
        // Important to have a list of type BinaryTreeNode instead of integer to keep track of the nodes later for traversal
        List<BinaryTreeNode> inorder = new ArrayList<>();
        inorder(root, inorder);

        for(int i = 0; i < inorder.size() - 1; i++) {
            inorder.get(i).right = inorder.get(i+1);
            inorder.get(i+1).left = inorder.get(i);
        }

        inorder.get(inorder.size() - 1).right = inorder.get(0);
        inorder.get(0).left = inorder.get(inorder.size() - 1);

        return inorder.get(0);
    }

    private void inorder(BinaryTreeNode root, List<BinaryTreeNode> result) {
        if(root == null) return;

        inorder(root.left, result);
        result.add(new BinaryTreeNode(root.value));
        inorder(root.right, result);

        return;
    }
}
