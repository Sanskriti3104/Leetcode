class Solution {
    public void sortColors(int[] nums) {
        int x=0;
        int y=0;
        int z=0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                x++;
            }else if(nums[i] == 1){
                y++;
            }else{
                z++;
            }
        }
        
        for(int i=0; i<x; i++){
            nums[i] = 0;
        }
        for(int i=x; i<x+y; i++){
            nums[i] = 1;
        }
        for(int i=x+y; i<x+y+z; i++){
            nums[i] = 2;
        }

    }
}