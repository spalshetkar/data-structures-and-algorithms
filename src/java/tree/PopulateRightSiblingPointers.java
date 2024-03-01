package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateRightSiblingPointers {
    private static class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode next_right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.next_right = null;
        }
    }

    private BinaryTreeNode populate_sibling_pointers(BinaryTreeNode root) {
        if(root == null) return null;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            BinaryTreeNode previous = null;

            for(int i = 0; i < queue.size(); i++) {
                BinaryTreeNode current = queue.poll();

                if(previous != null) previous.next_right = current;

                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);

                previous = current;
            }
        }

        return root;
    }
}
