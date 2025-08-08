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
    private List<Integer> inOrderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> inOrder = new ArrayList<>();

        if(root == null)    return inOrder;
        TreeNode node = root;

        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                inOrder.add(node.val);
                node = node.right;
            }
        }
        return inOrder;
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = inOrderTraversal(root);
        return inOrder.get(k-1);
    }
}