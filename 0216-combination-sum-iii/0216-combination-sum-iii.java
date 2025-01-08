class Solution {
    public void findCombination(int range,int k,int n,List<Integer> currentCombination,List<List<Integer>> result){

        if(range > 9 ||( n == 0 && currentCombination.size() == k)){
            if(n == 0 && currentCombination.size() == k){
                result.add(new ArrayList <> (currentCombination));
            }
            return;
        }

        for(int i = range; i<= 9; i++){
            if( i > n )  break;
            //if( count == k )    break;

            currentCombination.add(i);
            findCombination(i+1,k,n-i,currentCombination,result);
            currentCombination.remove(currentCombination.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(1,k,n,new ArrayList<>(),result);
        return result;
    }
}