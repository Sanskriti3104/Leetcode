/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)    return null;

        //Step 1: Insert a copy node after every original node
        Node temp = head;
        while(temp != null){
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }

        //Step 2: Assign randm pointers to copied node
        temp = head;
        while(temp != null){
            if(temp.random != null) temp.next.random = temp.random.next;
            temp = temp.next.next;
        }

        //Step 3: Separate the original list and the copied list
        Node dummy = new Node(0);
        Node copyTail = dummy;
        temp = head;

        while(temp != null){
            //Store the copied node
            Node copy = temp.next;

            //Restore the original list
            temp.next = copy.next;

            //Append the copied node
            copyTail.next = copy;
            copyTail = copy;

            //Move to the next original node
            temp = temp.next;
        }

        return dummy.next;
    }
}
//Time Complexity : O(N)
//Output Space : O(N)
//Auxiliary Space : O(1)