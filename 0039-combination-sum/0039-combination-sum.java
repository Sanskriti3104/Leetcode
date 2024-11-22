class Solution {
    public void findCombinationSum(int[] candidates, int target, int i, List<List<Integer>> result, List<Integer> currentCombinationSum){
        //base case
        if(i == candidates.length || target == 0){
            if(target == 0){
                result.add(new ArrayList<>(currentCombinationSum));
                /*The constructor new ArrayList<>(currentCombinationSum) ensures that
                changes to the original currentCombinationSum list 
                do not affect the version stored in result.*/
            }
            return;
        }

        //recursion 
        if(candidates[i] <= target){
            currentCombinationSum.add(candidates[i]);
            findCombinationSum(candidates,target - candidates[i],i,result,currentCombinationSum);
            currentCombinationSum.remove(currentCombinationSum.size() - 1);
        }
        findCombinationSum(candidates,target,i+1,result,currentCombinationSum);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinationSum(candidates,target,0,result,new ArrayList<>());
        return result;
    }
}