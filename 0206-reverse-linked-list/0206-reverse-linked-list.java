/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //Base case: if the list is empty or has only one node, return it
        if(head == null || head.next == null)
            return head;

        //Recursive call to reverse the rest of the list, which will be the new head
        ListNode newHead = reverseList(head.next);

        // Reversing the current link
        ListNode front = head.next;
        front.next = head;

        // Set the current node's next to null to avoid cycle in the reversed list
        head.next = null;

         // Return the new head of the reversed list
        return newHead;
    }
}