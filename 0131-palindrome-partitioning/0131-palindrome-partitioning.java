class Solution {
    static boolean isPalindrome(String temp){
        boolean palindrome = true;
        if(temp.length() == 1)  return palindrome;

        int l =0;
        int r =temp.length()-1;

        while(l<r){
            if(temp.charAt(l) == temp.charAt(r)){
                l++;
                r--;
            }else{
                palindrome = false;
                break;
            }
        }

        return palindrome;
    }
    static void findPartition(int idx,String s,List<List<String>> result,List<String> substring){
        if(idx == s.length()){
            result.add(new ArrayList<>(substring));
            return;
        }

        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s.substring(idx, i+1))){
                substring.add(s.substring(idx, i+1));
                findPartition(i+1,s,result,substring);
                substring.remove(substring.size() -1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> substring = new ArrayList<>();
        
        if(s.length() == 1){
            substring.add(s);
            result.add(new ArrayList<>(substring));
            return result;
        }

        findPartition(0,s,result,substring);
        return result;
    }
}