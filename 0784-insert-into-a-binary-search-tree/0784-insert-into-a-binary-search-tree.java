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
    static void insert(TreeNode temp,TreeNode node,int val){
        if(val < temp.val){
            if(temp.left != null){
                insert(temp.left,node,val);
            }
            else{
                temp.left = node;
            }
        }else{
            if(temp.right != null){
                insert(temp.right,node,val);
            }
            else{
                temp.right = node;
            }
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        TreeNode node = new TreeNode(val);
        insert(root,node,val);
        return root;
    }
}