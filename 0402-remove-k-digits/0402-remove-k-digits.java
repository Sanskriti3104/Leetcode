class Solution { 
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        if (k == num.length())
            return "0";

        for (int i = 0; i < num.length(); i++) {
            while (!s.isEmpty() && k > 0 && s.peek() - '0' > num.charAt(i) - '0') { 
                s.pop();
                k--;
            }
            s.push(num.charAt(i));
        }

        while (k > 0) {
            s.pop();
            k--;
        }

        if (s.isEmpty()) return "0";
        
        StringBuilder str = new StringBuilder();
        while (!s.isEmpty()) {
            str.append(s.pop());
        }

        while (str.length() != 0 && str.charAt(str.length() - 1) == '0') {
            str.setLength(str.length() - 1); 
        }

        if(str.length() == 0)   return "0";
        
        return str.reverse().toString();
    }
}
