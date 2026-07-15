class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateValidParenthesis(list, n, n, "");
        return list;
    }

    private void generateValidParenthesis(List<String> list, int open, int close, String current) {

        // Base case
        if (open == 0 && close == 0) {
            list.add(current);
            return;
        }

        // Place an opening parenthesis
        if (open > 0) {
            generateValidParenthesis(list, open - 1, close, current + "(");
        }

        // Place a closing parenthesis only if it keeps the string valid
        if (close > open) {
            generateValidParenthesis(list, open, close - 1, current + ")");
        }
    }
}