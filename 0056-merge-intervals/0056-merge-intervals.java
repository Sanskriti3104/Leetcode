class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(intervals[0][0],intervals[0][1]));

        for(int i=1; i<intervals.length; i++){
            List<Integer> last = result.get(result.size()-1);

            if(last.get(1) >= intervals[i][0]){
                last.set(1,Math.max(last.get(1),intervals[i][1]));
            }else{
                result.add(Arrays.asList(intervals[i][0],intervals[i][1]));
            }
        }

        int[][] merged = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            merged[i][0] = result.get(i).get(0);
            merged[i][1] = result.get(i).get(1);
        }

        return merged; 
    }
}