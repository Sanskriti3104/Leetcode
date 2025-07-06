class Solution {
    static List<String> construct(char[][] board,int n){
        List<String> temp = new ArrayList<>();
        for(int i=0; i<n; i++){
            temp.add(new String(board[i]));
        }
        return temp;
    }
    static void solve(int col,int n,char[][] board,List<List<String>> res,boolean[] rows,boolean[] lowerDiagonal,boolean[] upperDiagonal){
        if(col == n){
            res.add(construct(board,n));
            return;
        }

        for(int row=0; row<n; row++){
            if(!rows[row] && !lowerDiagonal[row+col] && !upperDiagonal[row - col + n - 1]){
                board[row][col] = 'Q';
                rows[row] = true;
                lowerDiagonal[row+ col] = true;
                upperDiagonal[row - col + n - 1] = true;

                solve(col+1,n,board,res,rows,lowerDiagonal,upperDiagonal);

                board[row][col] = '.';
                rows[row] = false;
                lowerDiagonal[row+ col] = false;
                upperDiagonal[row - col + n - 1] = false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(board[i],'.');
        }

        List<List<String>> res = new ArrayList<>();
        boolean[] rows = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2*n-1];
        boolean[] upperDiagonal = new boolean[2*n-1]; 
        solve(0,n,board,res,rows,lowerDiagonal,upperDiagonal);
        return res;
    }
}