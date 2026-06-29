class Solution {
    // Reverse the elements between the given indices (inclusive)
    public static void reverse( int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        
            // Move pointers toward the center
            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {
        //Rotating by n positions results in the same array 
        k = k % nums.length;

        //Reverse the entire array 
        reverse(nums,0,nums.length-1);
        //Reverse the first k elements to restore their order 
        reverse(nums,0,k-1);
        //Reverse the remaining elements to restore their order 
        reverse(nums,k,nums.length-1);
    }
}
//Time Complexity - O(N)
//Space Complexity - O(1)