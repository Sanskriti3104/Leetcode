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
    public void getLeaf(TreeNode root , List<Integer> leaf){
        if(root == null) return;

        if(root.left == null && root.right == null){
            leaf.add(root.val);
            return;
        }

        getLeaf(root.left,leaf);
        getLeaf(root.right,leaf);
        
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        getLeaf(root1,leaf1);

        List<Integer> leaf2 = new ArrayList<>();
        getLeaf(root2,leaf2);
        
        if(leaf1.size() != leaf2.size()){
            return false;
        }

        for(int leaf=0; leaf<leaf1.size(); leaf++){
            if(!leaf1.get(leaf).equals(leaf2.get(leaf))) return false;
        }
        
        return true;
    }
}