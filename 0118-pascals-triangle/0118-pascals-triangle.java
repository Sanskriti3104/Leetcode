class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> currentRow = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        //Loop through each row
        for(int i=1; i<= numRows; i++){

            for(int j = 0; j < i; j++){

                if(j == 0 || j == i - 1){
                    // First and last elements of each row are 1
                    currentRow.add(1);
                }else{
                    // Other elements are the sum of two elements above
                    currentRow.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j) );
                }

            }

            // Add the completed row to the result
            result.add( new ArrayList<>(currentRow) );
            // Clear current row for the next iteration
            currentRow.clear();

        }

        return result;
    }
}