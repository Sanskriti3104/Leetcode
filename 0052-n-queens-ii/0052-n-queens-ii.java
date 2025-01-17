class Solution {
    public List<String> construct(char chessBoard[][]){

        List<String> res = new ArrayList<>();

        for(int i=0; i<chessBoard.length; i++){
            StringBuilder str = new StringBuilder();
            for(int j=0; j<chessBoard.length; j++){
                str.append(chessBoard[i][j]);
            }
            res.add(str.toString());
        }

        return res;

    }
    public void solve(int col,char chessBoard[][],List<List<String>> result, int leftRow[],int lowerDiagonal[],int upperDiagonal[]){

        if(col == chessBoard.length){
            result.add(construct(chessBoard));
            return;
        }

        for(int row=0; row<chessBoard.length; row++){

            if( leftRow[row] == 0 &&
            lowerDiagonal[row + col] == 0 &&
            upperDiagonal[chessBoard.length - 1 + row - col] == 0 ){

                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[chessBoard.length - 1 + row - col] = 1;
                chessBoard[row][col] = 'Q';

                solve(col +1,chessBoard,result,leftRow,lowerDiagonal,upperDiagonal);

                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[chessBoard.length - 1 + row - col] = 0;
                chessBoard[row][col] = '.';

            }
        }

    }

    public int totalNQueens(int n) {

        char chessBoard[][] = new char[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                chessBoard[i][j] = '.';
            }
        }

        List<List<String>> result = new ArrayList<>();
        int leftRow[] = new int[n];
        int lowerDiagonal[] = new int[2 * n - 1];
        int upperDiagonal[] = new int[2 * n - 1];

        solve(0,chessBoard,result,leftRow,lowerDiagonal,upperDiagonal);

        return result.size();

    }
}