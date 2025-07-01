class Solution {
    static void findCombination(int idx,int[] candidates,int target,List<List<Integer>> result, List<Integer> combination){
        if(idx == candidates.length || target == 0){
            if(target == 0){
                result.add(new ArrayList<>(combination));
            }
            return;
        }

        for(int i = idx; i < candidates.length; i++){
            if( i > idx && candidates[i-1] == candidates[i]) continue;
            if(candidates[i] > target)    break;

            combination.add(candidates[i]);
            findCombination(i+1, candidates, target-candidates[i], result,combination);
            combination.remove(combination.size() - 1);
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0, candidates, target, result, new ArrayList<>());
        return result;
    }
}