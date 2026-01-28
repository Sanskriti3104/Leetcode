class Solution {
    public int calculateDays(int[] weights, int mid){
        long sum = 0;
        int days = 1;
        for(int w : weights){
            if(sum + w <= mid){
                sum += w;
            }else{
                days++;
                sum = w;
            }
        }
        return days;
    }
    public int sumOfCapacity(int[] weights){
        int sum = 0;
        for(int w : weights){
            sum += w;
        }
        return sum;
    }

    public int maxCapacity(int[] weights){
        int max = Integer.MIN_VALUE;
        for(int w : weights){
            max = Math.max(max,w);
        }
        return max;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = maxCapacity(weights);
        int high = sumOfCapacity(weights);
        int minCapacity = high;

        while(low <= high){
            int mid = low + (high - low)/2;
            int totalDays = calculateDays(weights,mid);

            if(totalDays > days){
                low = mid+1;
            }else{
                minCapacity = mid;
                high = mid-1;
            }
        }

        return minCapacity;
    }
}