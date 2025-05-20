class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap();
        int[] result = new int[nums1.length];

        for(int i = nums2.length - 1; i >= 0; i--){
            while(!st.empty() && st.peek() <= nums2[i] ){
                st.pop();
            }

            if(st.isEmpty()){
                hm.put(nums2[i],-1);
            }else{
                hm.put(nums2[i],st.peek());
            }
            st.push(nums2[i]);
        }

        for(int i=0; i<nums1.length; i++){
            result[i] = hm.get(nums1[i]);
        }

        return result;
    }
}