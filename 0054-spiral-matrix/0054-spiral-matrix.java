class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while(startRow <= endRow && startCol <= endCol){
            //Top Row
            for(int i= startCol; i<= endCol; i++){
                spiral.add(matrix[startRow][i]);
            }

            //Right column
            for(int i=startRow + 1; i<=endRow; i++){
                spiral.add(matrix[i][endCol]);
            }
            
            //Bottom Row
            for(int i=endCol-1; i>=startCol; i--){
                if (startRow == endRow) {
                    break;
                }
                spiral.add(matrix[endRow][i]);
            }
        
            //Left Column
            for(int i=endRow-1; i>startRow; i--){
                if (startCol == endCol) {
                    break;
                }
                spiral.add(matrix[i][startCol]);
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return spiral;
    }
}