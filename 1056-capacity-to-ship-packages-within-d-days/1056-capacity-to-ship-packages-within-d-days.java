class Solution {
    public int max(int[] weights){
        int maxElement = Integer.MIN_VALUE;
        for(int i=0; i< weights.length; i++)
            maxElement = Math.max(maxElement,weights[i]);
        return maxElement;
    }

    public int sum(int[] weights){
        int totalSum = 0;
        for(int i=0; i< weights.length; i++)
            totalSum += weights[i];
        return totalSum;
    }

    public int minDays(int[] weights, int mid){
        int weightCount = 0;
        int noOfDays = 1;

        for(int i=0; i< weights.length; i++){
            weightCount += weights[i];
            if(weightCount > mid){
                noOfDays++;
                weightCount = weights[i];
            }
        }
        
        return noOfDays;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = max(weights);
        int high = sum(weights);

        while(low <= high){
            int mid = (low + high)/2;

            if(minDays(weights,mid) <= days)    high = mid - 1;
            else    low = mid + 1;
        }

        return low;
    }
}