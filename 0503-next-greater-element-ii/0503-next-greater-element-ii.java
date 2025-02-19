class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> s = new Stack<>();

        for(int i=2*nums.length-1; i>=0; i--){
            while(!s.isEmpty() && nums[i%nums.length] >= s.peek()){
                        s.pop();
            }

            if(i<nums.length){
                nge[i] = s.isEmpty() ? -1 : s.peek();
            }
            s.push(nums[i%nums.length]);
        }

        return nge; 
    }
}