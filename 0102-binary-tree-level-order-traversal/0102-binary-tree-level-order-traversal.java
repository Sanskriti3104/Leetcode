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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)    return result;
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();
                if(current.left != null)   queue.offer(current.left);
                if(current.right != null)   queue.offer(current.right);
                subList.add(current.val);
            }
            result.add(subList);
        }

        return result;
    }
}