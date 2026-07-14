class Solution {
    public double myPow(double x, int n) {
        long N = n; //To prevent overflow for Integer.MIN_VALUE

        if(N<0){
            x = 1/x;      // Convert x^-n to (1/x)^n
            N = -N; 
        }

        return power(x,N);
    }
    private double power(double x, long n){
        if(n == 0) return 1.0;
        double half = power(x,n/2);

        if(n%2 == 0) return half*half;
        return x*half*half;
    }
}