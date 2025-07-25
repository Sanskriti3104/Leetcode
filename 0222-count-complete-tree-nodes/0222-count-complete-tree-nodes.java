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
    static int findLeftHeight(TreeNode root){
        int height = 0;

        while(root != null){
            height++;
            root = root.left;
        }

        return height;
    }
    static int findRightHeight(TreeNode root){
        int height = 0;

        while(root != null){
            height++;
            root = root.right;
        }

        return height;
    }
    static int totalHeight(TreeNode root){
        if(root != null){
            return 1 + totalHeight(root.left) + totalHeight(root.right);
        }else{
            return 0;
        }
    }
    public int countNodes(TreeNode root) {
        if(root == null)    return 0;
        if(root.left == null && root.right == null) return 1;

        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        if(leftHeight  == rightHeight){
            return ( 1 << leftHeight ) - 1;
        }else{
            return 1 + totalHeight(root.left) + totalHeight(root.right);
        }
    }
}