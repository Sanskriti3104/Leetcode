class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int result = -1;

        while(left <= right){
            int mid = (left + right)/2;

            if(nums[mid] == target){
                result = mid;
                break;
            }else if(target < nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return result;
    }
}