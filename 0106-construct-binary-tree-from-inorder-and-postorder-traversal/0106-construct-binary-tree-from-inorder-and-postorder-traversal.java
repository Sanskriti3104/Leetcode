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
    static TreeNode buildingTree(int[] postorder,int postStart, int postEnd,
                                 int[] inorder, int inStart, int inEnd,
                                 HashMap<Integer,Integer> inMap){

        if(postStart > postEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode();
        root.val = postorder[postEnd]; 
        int index = inMap.get(postorder[postEnd]);
        int rightTreeSize = inEnd - index;

        root.right = buildingTree(postorder, postEnd - rightTreeSize , postEnd -1,inorder, index+1, inEnd, inMap);
        root.left = buildingTree(postorder, postStart , postEnd - rightTreeSize -1 ,inorder, inStart, index-1, inMap);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> inMap = new HashMap<>();

        for(int i = 0; i< inorder.length; i++){
            inMap.put(inorder[i],i);
        }

        return buildingTree(postorder, 0, postorder.length -1,
                            inorder, 0, inorder.length -1,
                            inMap);
    }
}