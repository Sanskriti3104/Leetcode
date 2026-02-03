class Solution {
    public int startingPoint(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;

        while(low <= high){
            int mid = low+(high-low)/2;
            
            if(nums[mid] == target){
                ans = mid;
                high = mid-1;
            }else if(target > nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return ans;
    }

    public int endingPoint(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;

        while(low <= high){
            int mid = low+(high-low)/2;
            
            if(nums[mid] == target){
                ans = mid;
                low = mid+1;
            }else if(target < nums[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }  

    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];

        range[0] = startingPoint(nums,target);

        if(range[0] == -1)  range[1] = -1;
        else range[1] = endingPoint(nums,target);

        return range;
    }
}