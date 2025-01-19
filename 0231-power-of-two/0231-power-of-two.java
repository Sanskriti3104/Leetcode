class Solution {
    public String DecimalToBinary(int num){
        if (num == 0) { 
            return "0";
        }

        StringBuilder str = new StringBuilder();
        while (num > 0) {
            if(num % 2 == 1){
                str.append(1);
            }else{
                str.append(0);
            }

            num = num / 2;
        }

        return str.reverse().toString();
    }

    public boolean isPowerOfTwo(int n) {
        if(n < 0){
            return false;
        }
        String toBinary = DecimalToBinary(n);
        Boolean isPowerTwo = true;
        for(int i =0; i< toBinary.length(); i++){
            if(i == 0){
                if( toBinary.charAt(i) == '1'){
                    continue;
                }else{
                    return false;
                }
            }else{
                if( toBinary.charAt(i) == '1'){
                    isPowerTwo = false;
                    return isPowerTwo;
                }else{
                    continue;
                }
            }
        }

        return isPowerTwo;
    }
}