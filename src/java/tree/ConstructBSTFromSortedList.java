package tree;

import java.util.ArrayList;
import java.util.List;

public class ConstructBSTFromSortedList {
    private static class LinkedListNode {
        Integer value;
        LinkedListNode next;

        LinkedListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

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

    public BinaryTreeNode sorted_list_to_bst(LinkedListNode head) {
        if(head == null) return null;

        List<Integer> arr = new ArrayList<>();
        while(head != null) {
            arr.add(head.value);
            head = head.next;
        }

        BinaryTreeNode root = helper(arr, 0, arr.size() - 1);

        return root;
    }

    private BinaryTreeNode helper(List<Integer> arr, int start, int end) {
        // Base Case
        if(start > end) return null;

        // Recursive Case
        int mid = start + (end - start)/2;

        BinaryTreeNode node = new BinaryTreeNode(arr.get(mid));

        node.left = helper(arr, start, mid - 1);
        node.right = helper(arr, mid + 1, end);

        return node;
    }
}
