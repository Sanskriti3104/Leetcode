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
    //Method to find mid of the linked list
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //Method to reverse a linked list
    public ListNode reverse(ListNode start) {
        ListNode previous = null;
        ListNode current = start;
        ListNode after;
        while (current != null) {
            after = current.next;
            current.next = previous;
            previous = current;
            current = after;
        }
        return previous;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);   // Find the middle of the list
        ListNode temp2 = reverse(mid);      // Reverse the second half of the list
        ListNode temp1 = head;
        
        // Compare nodes from the start and the reversed second half
        while (temp2 != null) {
            if (temp1.val != temp2.val) {   // If values don't match, it's not a palindrome
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;    // If all nodes matched, it's a palindrome
    }
}