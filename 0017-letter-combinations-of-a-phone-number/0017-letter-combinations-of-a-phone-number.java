class Solution {
    static void findCombinations(int idx,String digits,HashMap<String,String> telbtn ,List<String> result,StringBuilder temp){
        if(idx == digits.length()){
            result.add(temp.toString());
            return;
        }

        String letters = telbtn.get(String.valueOf(digits.charAt(idx)));
        for(int i=0; i< letters.length(); i++){
            temp.append(letters.charAt(i));
            findCombinations(idx+1,digits,telbtn,result,temp);
            temp.deleteCharAt(temp.length() -1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)    return new ArrayList<>();

        HashMap<String, String> telbtn = new HashMap<>();
        telbtn.put("2","abc");
        telbtn.put("3","def");
        telbtn.put("4","ghi");
        telbtn.put("5","jkl");
        telbtn.put("6","mno");
        telbtn.put("7","pqrs");
        telbtn.put("8","tuv");
        telbtn.put("9","wxyz");

        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        findCombinations(0,digits,telbtn,result,temp);
        return result;
    }
}