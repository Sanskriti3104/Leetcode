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
    //Add node to the end of the list
    public static ListNode addNode(ListNode tail, int data){
        ListNode temp = new ListNode(data);
        tail.next = temp;
        tail = tail.next;
        return tail;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node for constructing the result list
        ListNode sumList = new ListNode();
        ListNode tail = sumList; 

        int carry = 0;
        int sum = 0;

        while(l1 != null || l2 != null){
            // Treat the missing node as 0 once a list is exhausted
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;

            sum = carry + x + y;
            
            // Compute carry and the current digit
            carry = sum / 10;
            sum = sum % 10;

            //Add a new node at the tail
            tail = addNode(tail,sum);

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        //If carry remains at the end 
        if(carry != 0){
            tail = addNode(tail,carry);
        }

        return sumList.next;
    }
}
//Time Complexity: O(max(m, n))
//Auxiliary Space: O(1)
//Output Space: O(max(m, n))