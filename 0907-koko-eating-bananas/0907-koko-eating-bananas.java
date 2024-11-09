class Solution {
    //maximum value in the array `piles`
    public int max(int[] piles){
        int maxElement = Integer.MIN_VALUE;
        for(int i =0; i<piles.length; i++){
            maxElement = Math.max(maxElement,piles[i]);
        }
        return maxElement;
    }

    //calculate the total hours required for Koko to eat all bananas
    //at a given eating speed `mid`
    public int reqHour(int[] piles,int mid){
        int total = 0;
        for(int i =0; i<piles.length; i++){
            total += Math.ceil((double)piles[i]/(double)mid);
        }
        return total;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;    // Minimum bananas Koko can eat per hour
        int high = max(piles);  // Maximum possible bananas per hour (largest pile) 

        // Use binary search to find the minimum eating speed
        while(low <= high){
            int mid = (low + high)/2;

            //Check if eating at speed `mid` allows Koko to finish in `h` hours or less
            if(reqHour(piles,mid) <= h){
                high = mid - 1;      // Try a lower speed to find the minimum
            }else{
                low = mid + 1;      // Increase speed as `mid` is too slow
            }
        }

        //`low` now points to the minimum eating speed required
        return low;
    }
}