class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if(dividend == divisor) return 1;

        boolean sign = true;
        if((dividend <= 0 && divisor > 0) || (dividend >= 0 && divisor < 0))      sign = false;

        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        long quotient =0;

        while(lDividend >= lDivisor){
            int count=0;
            long tempDivisor = lDivisor;
            while(lDividend >= (tempDivisor << 1)){
                tempDivisor = tempDivisor << 1;
                count++;
            }
            lDividend = lDividend - tempDivisor;
            quotient = (1 << count) + quotient;
        }

        if (quotient > Integer.MAX_VALUE) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return sign ? (int)quotient : (int)-quotient;
    }
}