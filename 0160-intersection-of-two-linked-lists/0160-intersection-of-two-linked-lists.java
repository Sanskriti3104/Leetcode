/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public static int sizeLinkedList(ListNode head){
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = sizeLinkedList(headA);
        int sizeB = sizeLinkedList(headB);

        int min = Math.min(sizeA,sizeB);

        while(headA != null && headB != null){
            if(sizeA - min > 0){
                while(sizeA - min > 0){
                    headA = headA.next;
                    sizeA = sizeA-1;
                }
            }else if(sizeB - min > 0){
                while(sizeB - min > 0){
                    headB = headB.next;
                    sizeB = sizeB-1;
                }
            }

            if(headA == headB){
                return headA;
            }else{
                headA = headA.next;
                headB = headB.next;
            }
        }

        return null;
    }
}