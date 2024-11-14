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
    //Find middle element 
    public ListNode findMid(ListNode head){
        if (head == null || head.next == null) {
        return head;
    }
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //Method to merge left and right part
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);  //Create dummy node
        ListNode tail= dummy;   //tail of dummy node

        // Traverse both lists simultaneously
        while(list1 != null && list2 != null){
            //Compare value, then add into list accordingly
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;  // Move tail forward
        }

        // Attach remaining elements if any
        if(list1 != null)   tail.next = list1;      //list 2 ends
        if(list2 != null)   tail.next = list2;      //list 1 ends

        return dummy.next;      //skip dummy node
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)   return head;    //No element or only one element

        ListNode middle = findMid(head);    //middle element
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;     //Split the linked list

        leftHead = sortList(leftHead);      //Sort left part
        rightHead = sortList(rightHead);    //Sort right part

        return merge(leftHead,rightHead);   //merge left part and right part
    }
}