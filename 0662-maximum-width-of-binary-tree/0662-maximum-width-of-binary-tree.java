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
class Pair {
    TreeNode node;
    int index;

    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root.left == null && root.right == null)     return 1;

        Queue<Pair> queue = new LinkedList<>();
        int maxSize = 0;
        int lastIdx =0;
        int firstIdx = 0;

        queue.offer(new Pair(root, 1));

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                Pair current = queue.poll();
                TreeNode currentNode = current.node;
                int currentIndex = current.index;

                if(i==0)    firstIdx = currentIndex;
                if(i == size-1)     lastIdx = currentIndex;

                if(currentNode.left != null){
                    queue.offer(new Pair(currentNode.left, 2 * currentIndex));
                }
                if(currentNode.right != null){
                    queue.offer(new Pair(currentNode.right,( 2 * currentIndex)+1));
                }
            }
            maxSize = Math.max(maxSize,lastIdx - firstIdx +1);
        }

        return maxSize;
    }
}