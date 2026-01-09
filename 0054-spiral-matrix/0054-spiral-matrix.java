class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();

        int firstRow = 0;
        int lastRow = matrix.length-1;

        int firstCol = 0;
        int lastCol = matrix[0].length-1;

        while(firstRow<=lastRow && firstCol<=lastCol){

            // top row 
            for(int i = firstCol; i<lastCol+1; i++){
                spiral.add(matrix[firstRow][i]);
            }
            firstRow++;

            // right column
            for(int i = firstRow; i<lastRow+1; i++){
                spiral.add(matrix[i][lastCol]);
            }
            lastCol--;

            // bottom row(if exists)
            if(firstRow <= lastRow){
                for(int i=lastCol; i>=firstCol; i--){
                    spiral.add(matrix[lastRow][i]);
                }
                lastRow--;
            }

            // left column(if exists)
            if(firstCol <= lastCol){
                for(int i=lastRow; i>=firstRow; i--){
                    spiral.add(matrix[i][firstCol]);
                }
                firstCol++;
            }
        }

        return spiral;
    }
}