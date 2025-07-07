class Solution {
    static boolean findIfExist(int idx,int i,int j,int row,int col,char[][] board,String word){
        if(idx == word.length()){
            return true;
        }
        
        if(i<0 || j<0 || i>=row || j>=col || board[i][j] != word.charAt(idx) || board[i][j] == '!'){
            return false;
        }

        //Avoid reusing a character again
        char c = board[i][j]; // a
        board[i][j] = '!';

        boolean top = findIfExist(idx+1,i-1,j,row,col,board,word);
        boolean bottom = findIfExist(idx+1,i+1,j,row,col,board,word);
        boolean left = findIfExist(idx+1,i,j-1,row,col,board,word);
        boolean right = findIfExist(idx+1,i,j+1,row,col,board,word);

        board[i][j] = c;

        return top || bottom || left || right;
    }
    public boolean exist(char[][] board, String word) {
        int row = board.length; // 3
        int col = board[0].length; // 4

        int idx =0;

        for(int i=0;i<row; i++){
            for(int j=0; j<col; j++){

                if(board[i][j] == word.charAt(idx)){
                    if(findIfExist(idx,i,j,row,col,board,word))
                    // 0 , 0, 0, 3 , 4 
                        return true;
                }

            }
        }

        return false;
    }
}