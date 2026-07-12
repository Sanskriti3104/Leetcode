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
        if(head == null || head.next == null)   return head;

        ListNode temp = head;
        ListNode tail = null;
        int length = 0;

        while(temp != null){
            tail = temp;
            temp = temp.next;
            length += 1;
        }

        k = k%length;
        if(k == 0)  return head;

        int newTailIndex = length - k - 1;
        temp = head;

        while(newTailIndex > 0){
            temp= temp.next;
            newTailIndex -= 1;
        }

        tail.next = head;
        ListNode newHead= temp.next;
        temp.next= null;
        
        return newHead;        
    }
}
//Time Complexity: O(n)
//Auxiliary Space: O(1)