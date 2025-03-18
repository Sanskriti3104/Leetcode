class Solution {
    public boolean divideArray(int[] nums) {
        HashMap <Integer,Integer> hm = new HashMap<>();
        int count = 0;

        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])){
                count = hm.get(nums[i]);
                hm.replace(nums[i],count + 1);
            }else{
                hm.put(nums[i],1);
            }
        }

        for (int v : hm.values()) {
            if (v % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}