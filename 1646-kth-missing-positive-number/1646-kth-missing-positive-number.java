class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 1;
        int missingCount = 0;
        int idx = 0;

        while(missingCount != k){
            
            if(idx < arr.length && arr[idx] == i){
                idx++;
            }else{
                missingCount++;
            }

            i++;
        }

        // Subtract 1 because i is incremented one extra time
        return i-1 ;    
    }
}