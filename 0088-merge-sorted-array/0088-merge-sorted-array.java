class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;
        int[] arr = new int[m+n];
        int idx =0;

        while(left < m && right < n){
            if (nums1[left] < nums2[right]){
                arr[idx] = nums1[left];
                idx++;
                left++;
            }else{
                arr[idx] = nums2[right];
                idx++;
                right++;
            }
        }

        while(left < m){
            arr[idx] = nums1[left];
            idx++;
            left++;
        } 

        while(right < n){
            arr[idx] = nums2[right];
            idx++;
            right++;
        }

        for(int i=0; i<m+n; i++ ){
            nums1[i] = arr[i];
        }

    }
}