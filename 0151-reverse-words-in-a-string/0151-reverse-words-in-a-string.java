class Solution {
    public String reverseWords(String s) {
        // Initialize idx as the length of the string
        int idx = s.length(); 
        
        //String to store the result
        String result = "";

        for (int i = s.length() - 1; i >= 0; i--) {

            //Check for the start of a word
            if ((i > 0 && s.charAt(i) != ' ' && s.charAt(i - 1) == ' ') || (i == 0 && s.charAt(i) != ' ' )) {
                // Add the extracted word to the result string with a space
                result = result + s.substring(i, idx) + " ";
            }
            //Update the index to mark the end of the current word
            else if (i > 0 && s.charAt(i) == ' ' && s.charAt(i - 1) != ' ') {
                idx = i;
            }
            //skip over spaces
            else {
                continue;
            }

        }

        return result.trim();
    }
}