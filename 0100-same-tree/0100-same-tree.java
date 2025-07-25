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
    static boolean checkSameTree(TreeNode p, TreeNode q){
        
        if(p == null && q == null)  return true;
        if(p == null || q == null)  return false;

        if(p.val != q.val)  return false;
        else    return checkSameTree(p.left, q.left) && checkSameTree(p.right, q.right);

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return checkSameTree(p, q);
    }
}