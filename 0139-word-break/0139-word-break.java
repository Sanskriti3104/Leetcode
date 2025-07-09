class Solution {
    static boolean findWordBreak(int idx, String s, Set<String> wordSet,Boolean[] memo){
        if(idx == s.length()){
            return true;
        }

        if(memo[idx] != null)   return memo[idx];

        for(int i = idx+1; i<= s.length(); i++){
            if(wordSet.contains(s.substring(idx,i))){
                if(findWordBreak(i,s,wordSet,memo)){
                    memo[idx] = true;
                    return true;
                }     
            }
        }

        memo[idx] = false;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean memo[] = new Boolean[s.length()];
        return findWordBreak(0,s,wordSet,memo);
    }
}