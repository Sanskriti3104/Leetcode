import java.util.HashMap;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        // Count the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (map.containsKey(currentChar)) {
                count = map.get(currentChar) + 1;
                map.put(currentChar, count);
            } else {
                map.put(currentChar, 1);
            }
        }

        // StringBuilder for the result
        StringBuilder str = new StringBuilder();

        // Sort and construct the result string
        while (!map.isEmpty()) {
            int longest = Integer.MIN_VALUE;
            char maxChar = 0;

            // Find the character with the highest frequency
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > longest) {
                    longest = entry.getValue();
                    maxChar = entry.getKey();
                }
            }

            // Append the character 'longest' times
            for (int i = 0; i < longest; i++) {
                str.append(maxChar);
            }

            // Remove the character from the map
            map.remove(maxChar);
        }

        return str.toString();
    }
}
