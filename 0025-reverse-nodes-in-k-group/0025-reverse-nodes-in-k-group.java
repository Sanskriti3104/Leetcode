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
    // Return the kth node starting from head (1-based indexing)
    // Returns null if fewer than k nodes remain
    private ListNode findKthNode(ListNode head, int k) {
        ListNode curr = head;

        while (curr != null && --k > 0) {
            curr = curr.next;
        }

        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)  return head;

        //Dummy node simplifies handling the first group
        ListNode dummy = new ListNode(0); 
        dummy.next = head;

        //Tail of the previously processed group
        ListNode previousGroupTail = dummy;

        while(true){
            //First node of the current group
            ListNode groupHead = previousGroupTail.next;

            //Last Node of the current group
            ListNode kthNode = findKthNode(groupHead, k);

            //Fewer than k nodes remain
            if (kthNode == null)
                break;

            //Store the head of the next group
            ListNode nextGroupHead = kthNode.next;

            ListNode prev = nextGroupHead;
            ListNode curr = groupHead;

            while (curr != nextGroupHead) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            //Connect the previous group with the reversed group
            previousGroupTail.next = kthNode;

            //GroupHead becomes the tail after reversal
            previousGroupTail = groupHead;
        }

        return dummy.next;
    }
}