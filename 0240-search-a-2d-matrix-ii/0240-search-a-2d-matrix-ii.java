class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length <1 || matrix[0].length <1)
            return false;

        int row = 0;
        int col = matrix[0].length - 1;

        while(row < matrix.length && col >= 0){  
            /*traverse through matrix till 
            row is less than number of rows and 
            column is greater than 0 */
            int element = matrix[row][col];

            if(element == target){
                return true;    //Element found
            }else if(element > target){
                col--;    
                //Decrement no. of column
            }else{
                row++;
                //Increment no. of row
            }
        }

        return false;   //Element not found
    }
}