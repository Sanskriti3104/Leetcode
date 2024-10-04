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
        ListNode current = head;
        int size = 0;

        //calculating size
        while(current != null){
            size++;
            current = current.next;
        }

        if(n == size){
            head = head.next;
            return head;
        }

        current = head;
        for(int i=1; i<size-n; i++){
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}