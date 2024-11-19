class Solution {
    public double calculatePower(double x,long n,double ans){
        //base case : if power(n) = 0
        if (n == 0)
            return ans;

        //If power is even, square x and halves n
        if(n%2 == 0){
            return calculatePower(x*x, n/2, ans);
        }else{
        //If power is odd, multiply ans by x and decrement n by 1
            return calculatePower(x ,n-1 ,ans * x);
        }

    }

    public double myPow(double x, int n) {
        double ans = 1.0;   //Initialize answer to 1
        long pow = n;   //Store value of n 

        //If power is negative
        if(pow < 0)     
            pow = (-1) * pow;   
            //Make it positive for calculation
        
        //Calculate power 
        double result = calculatePower(x, pow, ans);

        //If n is positive , return result 
        //If n is negative , return reciprocal of result 
        return (n >= 0) ? result : (1.0 / result);
    }
}