class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length; 
        int n= matrix[0].length; 

        boolean firstRow = false;
        boolean firstCol = false;

        //first row
        for(int i=0; i<n; i++){
            if(matrix[0][i] == 0)   firstRow = true;
        }

        //first column
        for(int i=0; i<m; i++){
            if(matrix[i][0] == 0)   firstCol = true;
        }

        //Traverse matrix
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //Set zero 
        for(int i=1; i<m; i++){ 
            for(int j=1; j<n; j++){ 
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] =0;
                }
            }
        }

        // First Row 
        if(firstRow){
            for(int i=0; i<n; i++){
                matrix[0][i] = 0;
            }
        }

        // First Col
        if(firstCol){
            for(int i=0; i<m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}