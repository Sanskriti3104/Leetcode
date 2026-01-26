class Solution {
    public boolean isPossible(int[] bloomDay, int m, int k, int mid){
        int counter = 0;
        int bouquets = 0;

        for(int day : bloomDay){
            if(day <= mid){
                counter++;
            }else{
                bouquets += counter/k;
                counter = 0;
            }
        }

        bouquets += counter / k;
        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if((long)bloomDay.length < (long)m*k)   return -1;

        int maxBloomDay = Integer.MIN_VALUE;
        int minBloomDay = Integer.MAX_VALUE;
        for(int day : bloomDay){
            minBloomDay = Math.min(day,minBloomDay);
            maxBloomDay = Math.max(day,maxBloomDay);
        }

        int low = minBloomDay;
        int high = maxBloomDay;
        int minRequiredDay = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(isPossible(bloomDay,m,k,mid)){
                minRequiredDay = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return minRequiredDay;
    }
}