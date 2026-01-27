class Solution {
    public long calculateDivisionSum(int[] nums,int mid){
        long sum = 0;
        for(int num : nums){
            sum += (num + mid - 1) / mid;
        }
        return sum;
    }
    public int findMaxElement(int[] nums){
        int maxElement = Integer.MIN_VALUE;
        for(int num : nums){
            maxElement = Math.max(maxElement,num);
        }
        return maxElement;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        if(nums.length == threshold)    return findMaxElement(nums);

        int low = 1;
        int high = findMaxElement(nums);
        int result = high;

        while(low <= high){
            int mid = low + (high - low)/2;

            long divisionSum = calculateDivisionSum(nums,mid);

            if(divisionSum > threshold){
                low = mid+1;
            }else{
                result = mid;
                high = mid-1;
            }
        }

        return result;
    }
}