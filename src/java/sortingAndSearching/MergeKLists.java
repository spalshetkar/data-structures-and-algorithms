package sortingAndSearching;

/*
Problem:
Given k linked lists where each one is sorted in the ascending order, merge all of them into a single sorted linked list.

Example:
{
"lists": [
[1, 3, 5],
[3, 4],
[7]
]
}
[1, 3, 3, 4, 5, 7]

Clarifying questions:
- Will there be duplicates? And is there any ordering required for it?
- How many lists will there be to merge?
- Can the linked list inside the list be null?

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

import java.util.List;


public class MergeKLists {
    class LinkedListNode {
        Integer value;
        LinkedListNode next;

        LinkedListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedListNode merge_k_lists(List<LinkedListNode> lists) {

        if(lists == null) return null;
        if(lists.size() == 1) return lists.get(0);

        LinkedListNode result = helper(lists.get(0), lists.get(1));
        for(int i = 2; i < lists.size(); i++) {
            result = helper(result, lists.get(i));
        }

        return result;
    }

    private LinkedListNode helper(LinkedListNode first, LinkedListNode second) {
        if(first == null) return second;
        if(second == null) return first;

        LinkedListNode result = new LinkedListNode(-1);
        LinkedListNode tail = result;

        while(first != null && second != null) {
            if(first.value < second.value) {
                tail.next = new LinkedListNode(first.value);
                tail = tail.next;

                first = first.next;
            }
            else {
                tail.next = new LinkedListNode(second.value);
                tail = tail.next;

                second = second.next;
            }
        }

        while(first != null) {
            tail.next = new LinkedListNode(first.value);
            tail = tail.next;

            first = first.next;
        }

        while(second != null) {
            tail.next = new LinkedListNode(second.value);
            tail = tail.next;

            second = second.next;
        }

        return result.next;
    }
}

/*
Time Complexity: O(n log k)
Space Complexity: O(1)
 */