class Solution {
   public void swap(int nums[] , int i,int j){
    int temp = nums[i];
    nums[i]= nums[j];
    nums[j]= temp;
   }

   public void findPermutation(int nums[],int idx,List<List<Integer>> result){
        if(idx == nums.length){
            // If we've used all elements, add the current permutation to the result
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : nums) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        for(int i = idx; i<nums.length; i++){
            // Swap to fix the current element
            swap(nums, idx, i);
            // Recurse for the next index
            findPermutation(nums, idx + 1, result);
            // Backtrack: revert the swap
            swap(nums, idx, i);
        }
   }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPermutation(nums,0,result);
        return result;
    }
}