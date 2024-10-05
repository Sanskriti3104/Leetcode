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
        //If the list is empty or contain only one element , reurn head
        if(head == null || head.next == null){
            return head;
        }

        //Intialize odd and even pointer 
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;   // To reconnect the even nodes later

        // Reorganize nodes in odd and even positions
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = even.next;    //Move odd pointer
            even.next = odd.next;
            even = odd.next;    //Move even pointer
        }

        //Attach even list after odd list
        odd.next = evenHead;
        return head;
    }
}