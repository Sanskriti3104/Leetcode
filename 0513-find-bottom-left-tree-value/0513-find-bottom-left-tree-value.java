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
    static void findLeftValue(TreeNode root, int level, List<Integer> result) {
        if (root == null) return;

        if (level == result.size()) {
            result.add(root.val); // first node at this level
        }

        findLeftValue(root.left, level + 1, result);   // left first
        findLeftValue(root.right, level + 1, result);
    }
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        findLeftValue(root, 0, result);
        return result.get(result.size() - 1); 
    }
}
