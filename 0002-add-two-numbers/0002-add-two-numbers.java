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
 //Add a node to the end of the linked list
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Creating a new List to store the sum
        ListNode sumList = new ListNode(0);

        //Intializing pointers for sumList 
        ListNode current = sumList;

        //Carry variable to store carry
        int carry =0;

        //Loop till both lists are traversed or until carry is left 
        while(l1 != null || l2 != null || carry != 0){
            //val1 & val2 to store the data
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            //updating sum and carry
            int sum = (val1 + val2 + carry)%10;
            carry = (val1 + val2 + carry)/10;

            //making new node to store the sum and moving current pointer
            current.next = new ListNode(sum);
            current = current.next;

            //Moving l1 and l2 pointer accordingly
            if( l1 != null ) l1 = l1.next;
            if( l2 != null ) l2 = l2.next;

        }
        // Return the next of sumList since it's the start of the actual result
        return sumList.next;
    }
}