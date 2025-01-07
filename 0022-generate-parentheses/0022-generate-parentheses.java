class Solution {
    public void generate (int openBracket, int closeBracket, int n, StringBuilder current, List<String> result){
        //Base condition 
        if(current.length() == 2*n){
            result.add(current.toString());
            return;
        }

        //If count of '(' is less than n
        if(openBracket < n){
            //Add it to the string
            current.append('(');
            //Increment the count of openBracket "(" and generate
            generate(openBracket+1,closeBracket,n,current,result);
            //Remove the last element from current String to form new combination
            current.delete(current.length()-1,current.length());
        }
        //If count of ')' is less than '('
        if(closeBracket < openBracket){
            //Add it to the string
            current.append(')');
            //Increment the count of closeBracket ")" and generate
            generate(openBracket,closeBracket+1,n,current,result);
            //Removethe last element from current String to form new combination
            current.delete(current.length()-1,current.length());
        }

    }
    public List<String> generateParenthesis(int n) {

        //List of string to store the result 
        List<String> result = new ArrayList<>();
        //Function call to  generate all combinations of well-formed parentheses
        generate(0,0,n,new StringBuilder(),result);
        //returnig result
        return result;

    }
}