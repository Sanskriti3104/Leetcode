class Solution {
    public void findSubset(int nums[],int i,List<Integer> currentSubset, List<List<Integer>> result){
        //base case
        if(i == nums.length){
            result.add(new ArrayList<>(currentSubset));
            /*Why Not Add currentSubset Directly?
If we added currentSubset directly to result without new, result would reference the same currentSubset object in memory. As a result, any changes to currentSubset would reflect across all instances in result, which would lead to incorrect subsets. The new keyword ensures that each subset stored in result is an independent object with a unique state at the time it was added.*/
            return;
        }
        //recursion
        //include current element
        currentSubset.add(nums[i]);
        findSubset(nums,i+1,currentSubset,result);

        //exclude current element
        currentSubset.remove(currentSubset.size() - 1);
        findSubset(nums,i+1,currentSubset,result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        //result to store the power set
        List<List<Integer>> result = new ArrayList<>();

        findSubset(nums,0,new ArrayList<>(),result);

        return result;
    }
}