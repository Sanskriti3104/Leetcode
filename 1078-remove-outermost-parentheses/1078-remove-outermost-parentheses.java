class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == '('){
                if(!stack.isEmpty()){
                    result.append(s.charAt(i));
                }
                stack.push(s.charAt(i));
            }else{
                stack.pop();
                if(!stack.isEmpty()){
                    result.append(s.charAt(i));
                }
            }
        }

        return result.toString();
    }
}