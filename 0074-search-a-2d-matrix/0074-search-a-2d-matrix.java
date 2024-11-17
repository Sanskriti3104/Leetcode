class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int m = 0;   //pointer for row
       int n = matrix[0].length - 1;    //pointer for column

        while(m < matrix.length && n >= 0){  
            /*traverse through matrix till 
            m is less than number of rows and 
            n is greater than 0 */
            int element = matrix[m][n];

            if(element == target){
                return true;    //Element found
            }else if(target < element){
                n--;    
                //Decrement no. of column
            }else{
                m++;
                //Increment no. of row
            }
        }

        return false;   //Element not found
    }
}