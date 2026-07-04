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
    public ListNode deleteMiddle(ListNode head) {
        //Single node list become empty after deletion
       if(head.next == null) return null;

       //Dummy Node(slow) positioned just before head because it will position just before middle 
       ListNode slow = new ListNode(0);
       slow.next = head;

       ListNode fast = head;

       while(fast != null && fast.next != null){
            // Move slow to the node before the middle
            slow = slow.next;
            fast = fast.next.next;
       }

       //Remove the middle node
       slow.next = slow.next.next;

       return head;
    }
}
//Time Complexity - O(N)
//Space Complexity - O(1)