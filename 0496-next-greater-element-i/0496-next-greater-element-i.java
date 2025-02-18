class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] nge = new int[nums1.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        for(int i=nums2.length-1; i>=0; i--){
            if(s.isEmpty()){
                hashMap.put(nums2[i], -1);
                s.push(nums2[i]);
            }else{
                if(nums2[i] > s.peek()){
                    while(!s.isEmpty() && nums2[i] >= s.peek()){
                        s.pop();
                    }
                    if(s.isEmpty()){
                        hashMap.put(nums2[i], -1);
                    }else{
                        hashMap.put(nums2[i], s.peek());
                    }
                    s.push(nums2[i]);
                }else{
                    hashMap.put(nums2[i], s.peek());
                    s.push(nums2[i]);
                }
            }
        }

        for(int i=0; i<nums1.length; i++){
            nge[i] = hashMap.get(nums1[i]);
        }

        return nge;
    }
}