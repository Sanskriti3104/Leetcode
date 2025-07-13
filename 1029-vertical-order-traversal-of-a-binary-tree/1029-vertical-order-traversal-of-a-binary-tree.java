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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,Map<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair<TreeNode,Pair<Integer,Integer>>> queue = new LinkedList<>();

        queue.offer(new Pair<>(root, new Pair<>(0, 0)));

        while(!queue.isEmpty()){
            Pair<TreeNode,Pair<Integer,Integer>> temp = queue.poll();

            TreeNode node = temp.getKey();
            int col = temp.getValue().getKey();
            int level = temp.getValue().getValue();

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(level, new PriorityQueue<>());
            map.get(col).get(level).offer(node.val);

            if(node.left != null){
                queue.offer(new Pair<>(node.left, new Pair<>(col-1, level+1)));
            }
            if(node.right != null){
                queue.offer(new Pair<>(node.right, new Pair<>(col+1, level+1)));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(Map<Integer,PriorityQueue<Integer>> levels : map.values()){
            List<Integer> vertical = new ArrayList<>();
            for(PriorityQueue<Integer> nodes : levels.values()){
                while(!nodes.isEmpty()){
                    vertical.add(nodes.poll());
                }
            }
            result.add(vertical);
        }
        return result;
    }
}