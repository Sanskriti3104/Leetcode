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
    static void findLeftValue(TreeNode root, int level,int[] maxDepth,int[] leftValue) {
        if (root == null) return;

        if (level > maxDepth[0]) {
            leftValue[0] = root.val;
            maxDepth[0] = level;
        }

        findLeftValue(root.left, level + 1,maxDepth,leftValue);   
        findLeftValue(root.right, level + 1,maxDepth,leftValue);

        return;
    }
    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;
        
        int[] leftValue = new int[1];
        int[] maxDepth = new int[1];
        findLeftValue(root, 0,maxDepth,leftValue);
        return leftValue[0];
    }
}
