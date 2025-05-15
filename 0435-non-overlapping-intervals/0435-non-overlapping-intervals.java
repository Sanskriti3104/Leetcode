class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 1;  // Always select the first meeting
        int lastEndTime = intervals[0][1];

        // Traverse through sorted intervals
        for(int i =1; i< intervals.length; i++){
            if(intervals[i][0] >= lastEndTime){
                count++;
                lastEndTime = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}