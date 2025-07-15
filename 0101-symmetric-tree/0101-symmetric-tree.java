/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)    return true;
        if(root.left == null && root.right == null) return true;

        Queue<TreeNode> queueL = new LinkedList<>();
        Queue<TreeNode> queueR = new LinkedList<>();
        queueL.offer(root.left);
        queueR.offer(root.right);

        while(!queueL.isEmpty() && !queueR.isEmpty()){
            TreeNode temp1 = queueL.poll();
            TreeNode temp2 = queueR.poll();

            if(temp1 == null && temp2 == null)  continue;
            if(temp1 == null || temp2 == null)  return false;

            if(temp1.val != temp2.val)  return false;

            queueL.offer(temp1.left);
            queueR.offer(temp2.right);
            queueL.offer(temp1.right);
            queueR.offer(temp2.left);
        }

        return true;
    }
}