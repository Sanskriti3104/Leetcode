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
    static int checkHeight(int[] diameter, TreeNode root){
        if(root == null)
            return 0;
        
        int l = checkHeight(diameter,root.left);
        int r = checkHeight(diameter,root.right);

        diameter[0] = Math.max(diameter[0], l+r);

        return 1 + Math.max(l,r);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        int height = checkHeight(diameter, root);
        return diameter[0];
    }
}