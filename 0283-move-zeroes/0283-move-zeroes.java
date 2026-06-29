class Solution {
    //Swap elements to restore in the required order
    public static void swap( int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public void moveZeroes(int[] nums) {
        //Two pointers
        int left = 0;
        int right = 0;

        while(right < nums.length){
            //Process the next non-zero element 
            if(nums[right] != 0){
                //Swap only when the non-zero element is not already in place
                if(left != right){
                    swap(nums,left,right);
                }left++;
            }
            right++;
        }
    }
}
//Time Complexity - O(N)
//Space Complexity - O(1)