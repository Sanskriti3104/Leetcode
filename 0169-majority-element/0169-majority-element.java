class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int majorElement = 0;

        for(int i =0; i< nums.length; i++){
            if(map.containsKey(nums[i])){
                count = map.get(nums[i]) + 1;
                if(count > (nums.length / 2)){
                    majorElement = nums[i];
                    break;
                }
                map.put(nums[i],count);
            }else{
                map.put(nums[i],1);
                majorElement = nums[i];
            }
        }

        return majorElement;
    }
}