class Solution {
    public int subarraySum(int[] nums, int k) {
        int s = 0;
        int count = 0;

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);

        for(int i=0; i<nums.length; i++){
            s += nums[i];
            if(hashMap.containsKey(s-k)){
                count += hashMap.get(s-k);
            }

            if(hashMap.containsKey(s)){
                hashMap.put(s, hashMap.get(s)+1); 
            }else{
                hashMap.put(s,1);
            }
        }

        return count;
    }
}