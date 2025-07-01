class Solution {
    static void findCombination(int i,int[] candidates,int target,List<List<Integer>> result, List<Integer> combination){
        if(i == candidates.length || target == 0){
            if(target == 0){
                result.add(new ArrayList<>(combination));
            }
            return;
        }

        if(candidates[i] <= target){
            combination.add(candidates[i]);
            findCombination(i, candidates, target-candidates[i], result,combination);
            combination.remove(combination.size() - 1);
        }

        findCombination(i+1, candidates, target, result,combination);        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List < List < Integer >> result = new ArrayList < > ();
        findCombination(0, candidates, target, result, new ArrayList < > ());
        return result;
    }
}