class Solution {
    static void findCombinations(int idx,int k,int n,List<List<Integer>> result,List<Integer> combination){
        if(k == 0 ){
            if(n == 0){
                result.add(new ArrayList<>(combination));
            }
            return;
        }

        for(int i=idx; i<10; i++){
            if(i <= n){
                combination.add(i);
                findCombinations(i+1,k-1,n-i,result,combination);
                combination.remove(combination.size()-1);
            }
        }
    
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(1,k,n,result,new ArrayList<>());
        return result;
    }
}