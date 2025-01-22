class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanValues = new HashMap<>();

        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int number = 0;

        for(int i=0; i<s.length(); i++){

            if( i != s.length() - 1 && ( romanValues.get(s.charAt(i)) < romanValues.get(s.charAt(i+1)) ) ){
                number = number - romanValues.get(s.charAt(i));
            }else{
                number = number + romanValues.get(s.charAt(i));
            }

        }

        return number;
    }
}