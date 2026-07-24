class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        palindromePartition(result,current,0,s);
        return result;
    }
    private boolean palindrome (String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end))    return false;
            start++;
            end--;
        }
        return true;
    }
    private void palindromePartition(List<List<String>> result,List<String> current,int idx,String s){
        if(idx == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = idx; i<s.length(); i++){
            if(palindrome(s,idx,i)){
                current.add(s.substring(idx,i+1));
                palindromePartition(result,current,i+1,s);
                current.remove(current.size() -1);
            }
        }
    }
}
//Time Complexity
//There are approximately O(2^n) possible partitions.
//For each partition, checking palindromes can take O(n)
//Therefore = O(n × 2^n)

//Space Complexity
//Recursion stack O(n)
//Current partition O(n)
//Output excluded.