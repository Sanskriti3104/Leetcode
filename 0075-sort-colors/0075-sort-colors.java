class Solution {
    public void sortColors(int[] nums) {
        int i=0 ,j=0,k =0;
        for(int m=0; m < nums.length; m++){
            if(nums[m] == 0)    i++;
            else if(nums[m] == 1)   j++;
            else    k++;
        }
        for(int m=0; m<i; m++){
            nums[m] = 0;
        }
        for(int m=0; m<j; m++){
            nums[m+i] = 1;
        }
        for(int m=0; m<k; m++){
            nums[m+i+j] = 2;
        }
    }
}