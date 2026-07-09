/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    // Reverse the entire linked list and return the new head
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    // Return the kth node starting from head (1-based indexing)
    // Returns null if fewer than k nodes remain
    private ListNode findKthNode(ListNode head, int k) {
        ListNode curr = head;

        while (curr != null && --k > 0) {
            curr = curr.next;
        }

        return curr;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        // Base case: fewer than k nodes remain
        ListNode kthNode = findKthNode(head, k);

        if (kthNode == null)
            return head;

        // Save the head of the next group
        ListNode nextGroupHead = kthNode.next;

        // Temporarily detach the current group
        kthNode.next = null;

        // Reverse the current group
        ListNode newGroupHead = reverseList(head);

        // Recursively reverse the remaining groups
        ListNode remainingGroups = reverseKGroup(nextGroupHead, k);

        // Original head becomes the tail after reversal
        head.next = remainingGroups;

        return newGroupHead;
    }
}