class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        //Calculate the expected sum of numbers from 0 to n
        int totalSum = (n*(n+1))/2;
        int givenSum = 0;

        //Calculate the sum of the given array elements
        for(int i=0; i<n; i++){
            givenSum += nums[i];
        }

        //The difference gives the missing number
        return totalSum - givenSum;
    }
}
//Time Complexity - O(N)
//Space Complexity - O(1)