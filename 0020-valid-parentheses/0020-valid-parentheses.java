class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if(s.length() == 0)   return true;

        for(int i=0; i< s.length(); i++){

            // Push opening brackets to stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' ||s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            // Check closing brackets
            else {
                if (stack.isEmpty()) return false; // No matching opening bracket
                char top = stack.pop();
                if ((s.charAt(i) == ')' && top != '(') ||
                    (s.charAt(i) == '}' && top != '{') ||
                    (s.charAt(i) == ']' && top != '[')) {
                    return false; // Mismatched brackets
                }
            }

        }

        // Stack must be empty for a valid string
        return stack.isEmpty();
    }
}