class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        boolean flag = false;
        while (low<=high) {
            int mid = (low + high)/2;

            //target is found
            if (nums[mid] == target){
                flag = true ;
                break;
            }

            //if nums[low] = nums[mid] = nums[high]
            if((nums[low] == nums[mid]) && (nums[mid] == nums[high])){
                low = low + 1;
                high = high - 1;
                continue;
            }

            //left part is sorted
            if(nums[low] <= nums[mid]){
                if((nums[low] <= target) && (target <= nums[mid]))
                    high = mid - 1;
                else
                    low = mid + 1;

            }

            //right part is sorted
            else{
                if((nums[mid] <= target) && (target <= nums[high]))
                    low = mid + 1;
                else
                    high = mid -1;
            }
        }

        return flag;
    }
}