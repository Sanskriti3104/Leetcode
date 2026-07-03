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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        //// Separate odd-indexed and even-indexed nodes
        while(even != null && even.next != null){
            //Link current odd node to the next odd node
            odd.next = odd.next.next;
            odd = odd.next;

            //Link current even node to next even node
            even.next = even.next.next;
            even = even.next;
        }

        //Append the end of odd node list to even node
        odd.next = evenHead;

        return head;
    }
}
//Time Complexity - O(N)
//Space Complexity - O(1)