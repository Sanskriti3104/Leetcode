class Solution {
    public void setRowZero(int i, int[][] matrix) {
        for(int m=0; m<matrix[0].length; m++){
            matrix[i][m] = 0;
        }
    }

    public void setColZero(int j, int[][] matrix) {
        for(int m=0; m<matrix.length; m++){
            matrix[m][j] = 0;
        }
    }
    
    public void setZeroes(int[][] matrix) {
        int rows[] = new int[matrix.length];
        int columns[] = new int[matrix[0].length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows[i] = -1;
                    columns[j] = -1;
                }
            }
        }

        for(int i=0; i<rows.length; i++){
            if(rows[i] == -1)   setRowZero(i,matrix);
        }

        for(int j=0; j<columns.length; j++){
            if(columns[j] == -1)   setColZero(j,matrix);
        }

        return;
    }
}