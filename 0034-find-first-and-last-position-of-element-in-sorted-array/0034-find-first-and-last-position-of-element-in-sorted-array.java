class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        int first = -1;
        int last = -1;

        //finding firat occurence
        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == target){
                first = mid;
                high = mid-1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
        }

        //resetting value of low and high
        low = 0;
        high = nums.length -1;

        //finding last occurence
        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == target){
                last = mid;
                low = mid+1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
        }

        //returning the value of first and last occurence 
        return new int[] {first,last};
    }
}