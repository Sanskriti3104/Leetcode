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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //calculating size
        ListNode current = head;
        int sz =0;
        while(current != null){
            sz++;
            current = current.next;
        }

        //if index of removing element = size of the linked list 
        if(n == sz){
            head = head.next;
            return head;
        }

        current = head;
        //other cases
        for(int i=1; i<sz-n; i++){
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}