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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack <TreeNode> stack = new Stack<>();
        List<Integer> postorder = new ArrayList<>();

        if(root == null)    return postorder;
        TreeNode node = root;
        TreeNode temp = null;
        
        while(node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    postorder.add(temp.val);
                    while(!stack.isEmpty() && temp == stack.peek().right ){
                        temp = stack.pop();
                        postorder.add(temp.val);
                    }
                    if (!stack.isEmpty()) {
                        temp = stack.peek().right;
                        node = temp;
                    }
                }else{
                    node = temp;
                }
            }
        }

        return postorder;
    }
}