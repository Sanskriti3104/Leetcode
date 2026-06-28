class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        //If the length of the array is 1 , then return 1 
        if(arr.length == 1) return 1;

        //Rearrange the array by sorting it 
        Arrays.sort(arr);

        //First element should always be 1
        arr[0] = 1;

        //Adjust each element to make the adjacent difference condition
        for(int i =1; i<arr.length; i++){
            //Ensure the difference from the previous element is at most 1
            arr[i] = Math.min(arr[i],arr[i-1]+1);
        }

        //The array remains non-decreasing, so the last element is the maximum
        return arr[arr.length-1];
    }
}
//Time Complexity - O(nlogn)
//Space Complexity - O(log n) (due to recursion in Java's Arrays.sort(int[]))