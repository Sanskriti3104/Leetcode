class Solution {
    public void findLeftRange(int[] nums, int left, int mid, int target, int[] result) {
        int l = left;
        int r = mid;

        while(l <= r){
            int m = l + (r - l)/2;

            if(target == nums[m]){
                result[0] = m;
                r = m - 1;
            }else if(target < nums[m]){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }

        return;
    }

    public void findRightRange(int[] nums, int mid, int right, int target, int[] result) {
        int l = mid;
        int r = right;

        while(l <= r){
            int m = l + (r - l)/2;

            if(target == nums[m]){
                result[1] = m;
                l = m + 1;
            }else if(target < nums[m]){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }

        return;
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result[] = {-1,-1};

        while(left <= right){
            int mid = left + (right - left)/2;
            
            if(target == nums[mid]){
                findLeftRange(nums,left,mid,target,result);
                findRightRange(nums,mid,right,target,result);
                break;
            }else if(target < nums[mid]){
                right = mid-1;
            }else{
                left = mid +1;
            }
        }

        return result;
    }
}