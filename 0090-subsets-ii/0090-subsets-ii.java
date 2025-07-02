class Solution {
    static void findSubset(int i,boolean prevTaken, int[] nums,List<List<Integer>> result,List<Integer> subset){
        if(i == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        if(i == 0  || nums[i] != nums[i-1] || prevTaken){
            subset.add(nums[i]);
            findSubset(i+1, true, nums, result, subset);
            subset.remove(subset.size() -1);
        }
        findSubset(i+1, false, nums, result, subset);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        findSubset(0,false, nums, result, new ArrayList<>());
        return result;
    }
}