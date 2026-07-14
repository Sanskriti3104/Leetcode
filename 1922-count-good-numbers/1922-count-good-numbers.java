class Solution {
    public int countGoodNumbers(long n) {
        int MOD = 1_000_000_007;

        if(n%2==0)  return (int) (( power(20,n/2) )% MOD);
        return (int) (( 5 * power(20,n/2) ) % MOD );
    }
    private long power(int x, long n){
        if(n == 0) return 1;
        int MOD = 1_000_000_007;

        long half = power(x,n/2);

        // Cast product to long before applying modulo
        long halfSquare = (half * half) % MOD;

        if( n % 2 == 0) return halfSquare;
        return (x * halfSquare) % MOD;
    }
}