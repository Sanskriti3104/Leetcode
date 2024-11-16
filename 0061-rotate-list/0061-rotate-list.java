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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)     return head;

        //calculating size
        ListNode temp = head;
        int size = 1;
        while(temp.next != null){
            ++size;
            temp = temp.next;
        }

        //link last node to first node
        temp.next = head;

        //rotating length
        k = k%size;

        //get end of linked list
        int end = size - k;

        while(end--!=0) temp = temp.next;
        //breaking last node link and pointing to NULL
        head = temp.next;
        temp.next = null;
        
        return head;        
    }
}