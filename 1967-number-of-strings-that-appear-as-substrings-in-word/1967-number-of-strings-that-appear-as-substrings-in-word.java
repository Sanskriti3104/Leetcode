class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int countString = 0;

        for(int i =0; i<patterns.length; i++){
            if(word.contains(patterns[i]))   countString++;
        }

        return countString;
    }
}
//Time Complexity: Approximately O(m × L × P), where:
//      m = number of patterns
//      L = length of word
//      P = average pattern length
//Space Complexity: O(1)