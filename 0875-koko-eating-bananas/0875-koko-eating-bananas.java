class Solution {
    public long calculateHours(int[] piles, int speed){
        long hours = 0;
        for(int pile: piles){
            hours += (pile + speed -1)/speed;   // ceil division
        }
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile : piles){
           maxPile = Math.max(pile,maxPile);
        }

        int low = 1;
        int high = maxPile;
        int ans = maxPile;

        while(low <= high){
            int mid = low + (high - low)/2;
            
            long hoursNeeded = calculateHours(piles,mid);
            if(hoursNeeded <= h){
                ans = mid;      //possible answer
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }
}