class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m-1; // last index of initialized nums1
        int b = m+n-1;  // last index of nums1 total
        int c = n-1;    // last index of nums2

        while(a >= 0 && c >= 0){
            if(nums1[a]<nums2[c]){
                nums1[b] = nums2[c];
                c--;
            }else{
                nums1[b] = nums1[a];
                a--;
            }
            b--;
        }

        // If nums2 still has elements, copy them
        while (c >= 0) {
            nums1[b] = nums2[c];
            b--;
            c--;
        }
        return;
    }
}