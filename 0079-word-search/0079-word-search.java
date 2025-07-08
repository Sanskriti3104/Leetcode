class Solution {
    static boolean findIfExist(int idx,int i,int j,char[][] board,String word){
        if(idx == word.length()){
            return true;
        }
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != word.charAt(idx) || board[i][j] == '!'){
            return false;
        }

        //Avoid reusing a character again
        char c = board[i][j];
        board[i][j] = '!';

        boolean top = findIfExist(idx+1,i-1,j,board,word);
        boolean bottom = findIfExist(idx+1,i+1,j,board,word);
        boolean left = findIfExist(idx+1,i,j-1,board,word);
        boolean right = findIfExist(idx+1,i,j+1,board,word);

        board[i][j] = c;

        return top || bottom || left || right;
    }
    public boolean exist(char[][] board, String word) {

        if(word.length() > board.length*board[0].length){
            return false;
        }

        int[] boardFreq = new int[128];
        int[] wordFreq = new int[128];

        for(char[] row : board){
            for(char c : row){
                boardFreq[c]++;
            }
        }

        for(char c: word.toCharArray()){
            wordFreq[c]++;
            if(wordFreq[c] > boardFreq[c]){
                return false;
            }
        }

        for(int i=0;i<board.length; i++){
            for(int j=0; j<board[0].length; j++){

                if(board[i][j] == word.charAt(0)){
                    if(findIfExist(0,i,j,board,word))
                        return true;
                }

            }
        }

        return false;
    }
}