class Solution {
    public void setZeroes(int[][] matrix) {
        //ArrayList to store the indexes
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>(); 

        //Add indexes accordingly to rows and column
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        //Convert row element to zero 
        for(int i=0; i<rows.size(); i++){
            for(int j=0; j<matrix[0].length; j++){
                matrix[rows.get(i)][j] = 0;
            }
        }

        //Convert column element to zero
        for(int i=0; i<columns.size(); i++){
            for(int j=0; j<matrix.length; j++){
                matrix[j][columns.get(i)] = 0;
            }
        }
    }
}