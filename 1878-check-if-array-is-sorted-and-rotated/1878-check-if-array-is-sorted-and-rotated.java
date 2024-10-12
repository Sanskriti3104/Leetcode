class Solution {
    public boolean check(int[] nums) {
        int index = 0;
        boolean flag = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                index = i + 1;
                break;
            }
        }

        if (index == 0) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    flag = false;
                    return flag;
                }
            }
        } else {
            for (int i = index; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    flag = false;
                    return flag;
                }
            }
            if(nums[nums.length-1] > nums[0]){
                flag = false;
                return flag;
            }
        }
        return flag;
    }
}