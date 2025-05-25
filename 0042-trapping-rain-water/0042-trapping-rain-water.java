class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int waterTrapped =0;

        int left =0;
        int leftMax =0;
        int right =n-1;
        int rightMax =0;

        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    waterTrapped += (leftMax - height[left]);
                }
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    waterTrapped += (rightMax - height[right]);
                }
                right--;
            }
        }

        return waterTrapped;
    }
}