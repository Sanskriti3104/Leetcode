class Solution {
    public boolean makingBouquet(int[] bloomDay, int m, int k, int minDay){
    int countFlower =0;
    int countBouquet =0;

        for(int i=0; i< bloomDay.length; i++){
            if(bloomDay[i] <= minDay){      // The flower has bloomed
                countFlower++;      
                if(countFlower == k){   // Enough flowers for a bouquet
                    countBouquet++;
                    countFlower = 0;    // Reset flower count for the next bouquet 
                }
            }else{      
                countFlower = 0;     // Reset if flower hasn't bloomed in time
            }
        }

        return countBouquet >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        //impossible case
        if(bloomDay.length < (long)(m*k))
            return -1;

        int low = Integer.MAX_VALUE;    
        int high = Integer.MIN_VALUE;

        //find minimum and maximum value 
        for(int i =0; i<bloomDay.length; i++){
            low = Math.min(low,bloomDay[i]);
            high = Math.max(high,bloomDay[i]);
        }

        //apply binary search
        while(low <= high){
            int mid = (low + high)/2;

            if(makingBouquet(bloomDay,m,k,mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        // Final check: Verify if it's possible with the final `low`
        if (makingBouquet(bloomDay, m, k, low)) {
            return low; // Minimum days to make `m` bouquets
        } else {
            return -1;  // Impossible to make `m` bouquets
        }
    }
}