class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void findPermutation(int idx, int[] nums, List<List<Integer>> result){
        if(idx == nums.length){
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for(int i = idx; i < nums.length; i++){
            swap(nums, idx, i);
            findPermutation(idx + 1, nums, result);
            swap(nums, idx, i); // backtrack
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPermutation(0, nums, result);
        return result;
    }
}
