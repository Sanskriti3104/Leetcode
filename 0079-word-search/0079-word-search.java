class Solution {
    public boolean exist(char[][] board, String word) {
        boolean isExist = false;
        //Find first letter
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                //Found first letter than check word exists or not
                if(board[i][j] == word.charAt(0)){
                    char c = board[i][j];
                    board[i][j] = '#';
                    isExist = checkExist(board,word,i,j,1);
                    board[i][j] = c;
                    //If the word exists return true(isExist)
                    if(isExist) return isExist;
                }
            }
        }
        return isExist;
    }

    //Check whether the cell address is valid
    private boolean isValidCell(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    //Check whether the word exists or not
    private boolean checkExist(char[][] board, String word, int row, int col, int index){
        //Base Case 
        if(index == word.length()){
            return true;
        }

        char ch = word.charAt(index);

        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;

        //Check up 
        if(isValidCell(board,row-1,col) && board[row-1][col] == ch){
            char c = board[row-1][col];
            board[row-1][col] = '#';
            up = checkExist(board,word,row-1,col,index+1);
            board[row-1][col] = c;
        }
        //Check left
        if(isValidCell(board,row,col-1) && board[row][col-1] == ch){
            char c = board[row][col-1];
            board[row][col-1] = '#';
            left = checkExist(board,word,row,col-1,index+1);
            board[row][col-1] = c;
        }
        //Check down 
        if(isValidCell(board,row+1,col) && board[row+1][col] == ch){
            char c = board[row+1][col];
            board[row+1][col] = '#';
            down = checkExist(board,word,row+1,col,index+1);
            board[row+1][col] = c;
        }
        //Check right 
        if(isValidCell(board,row,col+1) && board[row][col+1] == ch){
            char c = board[row][col+1];
            board[row][col+1] = '#';
            right = checkExist(board,word,row,col+1,index+1);
            board[row][col+1] = c;
        }

        return up||left||down||right;
    }
}