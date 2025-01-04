class Solution {
    public int calculatePower(int x1, int x2, long n, int ans, int MOD) {

        // Base case: if power(n) = 0
        if (n == 0)
            return ans;

        // If power is even, square x1 and x2, and halve n
        if (n % 2 == 0) {
            return calculatePower(
                (int)((long)x1 * x1 % MOD), 
                (int)((long)x2 * x2 % MOD), 
                n / 2, ans, MOD);
        } else {
        // If power is odd, multiply ans by x1 and x2, and decrement n by 1
            return calculatePower(
                x1, 
                x2, 
                n - 1, 
                (int)((long)ans * x1 % MOD * x2 % MOD), 
                MOD);
        }
    }

    public int countGoodNumbers(long n) {
        long pow = n;
        int MOD = 1000000007;
        int ans = 1;
        int result;

        //if length is 0 , no good string will be formed
        if (pow == 0) {
            return 0;
        } else {
            //if pow is even calculate the power for both 5(n/2) and 4(n/2)
            if (pow % 2 == 0) {
                result = calculatePower(5, 4, pow / 2, ans, MOD);
                return result;
            } else {
                //if pow is even calculate the power for both 5(n/2) and 4(n/2) and then multiply it with 5 for last position
                result = (int)((long)calculatePower(5, 4, pow / 2, ans, MOD) * 5 % MOD);
                return result;
            }
        }
    }
}
