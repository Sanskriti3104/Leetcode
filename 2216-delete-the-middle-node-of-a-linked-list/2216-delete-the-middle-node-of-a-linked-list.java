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
        //linked list has one element
        if(head.next == null){
            head = null;
        }

        //linked list has two element
        else if(head.next.next == null){
            head.next = null;
        }

        //linked has more than two elements
        else{
            ListNode slow = head;
            ListNode fast = head;

            // when fast != null && fast.next != null slow will point at mid of the list
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            //instead of deleting , removing it by copying the data of the next node and bypassing the next node in the list.
            slow.val = slow.next.val;
            slow.next = slow.next.next;
        }

        //returning the head of the modified linked list
        return head;
    }
}