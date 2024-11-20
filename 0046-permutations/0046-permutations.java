class Solution {
    public void swap(int i,int j,int nums[]){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void findPermutation(int nums[],int index,List<List<Integer>> result){
        if(index == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                ds.add(nums[i]);
            }
            result.add(new ArrayList<>(ds));
            return;
        }
        for(int i= index;i<nums.length;i++){
            swap(i,index,nums);
            findPermutation(nums,index + 1,result);
            swap(i,index,nums);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        findPermutation(nums,0,result);
        return result;
        
    }
}