class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int i = s.length()-1;

        while(i >= 0){

            //Skip spaces
            while(i>=0 && s.charAt(i) == ' ')   i--;
            if(i < 0)   break;

            //Mark word end
            int end = i;

            //Find word start
            while(i>=0 && s.charAt(i) != ' ')   i--;
            int start = i+1;

            //Append word
            ans.append(s.substring(start, end + 1));
            ans.append(" ");
        }
       
        return ans.toString().trim();
    }
}