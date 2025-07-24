/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static void markParent(TreeNode root,HashMap <TreeNode,TreeNode> parentTrack){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left != null){
                parentTrack.put(current.left,current);
                queue.offer(current.left);
            }
            if(current.right!= null){
                parentTrack.put(current.right,current);
                queue.offer(current.right);
            }
        }
    } 

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentTrack = new HashMap<>();
        markParent(root,parentTrack);

        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);

        int currentLevel = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            if(currentLevel == k)   break;
            currentLevel++;

            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();

                if(current.left != null && !visited.contains(current.left)){
                    queue.offer(current.left);
                    visited.add(current.left); 
                }

                if(current.right!= null && !visited.contains(current.right)){
                    queue.offer(current.right);
                    visited.add(current.right); 
                }

                if(parentTrack.get(current) != null && !visited.contains(parentTrack.get(current))){
                    queue.offer(parentTrack.get(current));
                    visited.add(parentTrack.get(current));
                }
            }
        }

        List<Integer> result = new ArrayList();
        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }

        return result;
    }
}