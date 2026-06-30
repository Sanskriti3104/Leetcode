class Solution {
    public int numberOfSubstrings(String s) {
        //Variable Size Sliding Window 
        int left = 0;
        int right = 0;

        int count = 0;

        int[] freqArray = {0, 0, 0};

        //Expand the window by including the current character
        while(right < s.length()){
            char ch = s.charAt(right);

            if(ch == 'a') freqArray[0] = freqArray[0]+1;
            else if(ch == 'b') freqArray[1] = freqArray[1]+1;
            else freqArray[2] = freqArray[2]+1;

            // While the window contains all three characters,
            // count all valid substrings starting at 'left'
            while(freqArray[0] > 0 && freqArray[1] > 0 && freqArray[2] > 0){
                count += (s.length() - right);
                
                char c = s.charAt(left);
                if(c == 'a') freqArray[0] = freqArray[0]-1;
                else if(c == 'b') freqArray[1] = freqArray[1]-1;
                else freqArray[2] = freqArray[2]-1;

                // Remove the leftmost character and shrink the window
                left++;
            }

            right++;
        }

        return count;
    }
}