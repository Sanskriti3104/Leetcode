class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveBill =0;
        int tenBill =0;
        
        for(int i=0; i<bills.length; i++){
            if(bills[i] == 5){
                fiveBill++;
            }else{
                if(bills[i] == 10){
                    if(fiveBill>= 1){
                        fiveBill--;
                        tenBill++;
                    }else{
                        return false;
                    }
                }else{
                    if(fiveBill>= 1 && tenBill >=1){
                        fiveBill--;
                        tenBill--;
                    }else if(fiveBill >=3){
                        fiveBill -=3;
                    }else{
                        return false;
                    }
                }
            }
        }

        return true;
    }
}