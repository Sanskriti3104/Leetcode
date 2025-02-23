class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int longestLength = 0;
        int left=0; 
        int right=0;

        while(right<s.length()){
            if(hashMap.containsKey(s.charAt(right))){
                hashMap.remove(s.charAt(left));
                left++;
            }else{
                hashMap.put(s.charAt(right),1);
                longestLength = Math.max(longestLength,right-left+1);
                right++;
            }
        }

        return longestLength;
    }
}