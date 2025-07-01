class Solution {
    static void findSubset(int i,int[] nums,List<List<Integer>> result,List<Integer> subset){
        if(i == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        findSubset(i+1, nums, result, subset);
        subset.remove(subset.size() -1);
        findSubset(i+1, nums, result, subset);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubset(0, nums, result, new ArrayList<>());
        return result;
    }
}