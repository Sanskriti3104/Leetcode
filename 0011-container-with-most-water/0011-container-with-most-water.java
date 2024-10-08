class Solution {
    public int maxArea(int[] height) {
        int MaxArea = Integer.MIN_VALUE;
        int area =0;
        int i=0;
        int j= height.length-1;
        while(i<j){
            area = (Math.min(height[i],height[j])) * (j-i);
            if(MaxArea<area){
                MaxArea = area;
            }
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return MaxArea;
    }
}