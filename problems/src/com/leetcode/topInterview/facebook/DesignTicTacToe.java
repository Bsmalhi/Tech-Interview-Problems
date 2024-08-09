class DesignTicTacToe {
    /**
        n x n board
        move is guaranteed to be valid, when winning condition reached nomore valid moves
        a player who succeeds in placing n of their marks in a horizontal, vertical or diagonal rows wins game
     */
    int[][] board;
    int n;
    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if(checkRow(row, player) ||
            checkCol(col, player) ||
            (row == col && checkDiagonal(player)) || // row is same as col means its a diagonal 
            (col == n - row - 1 && checkAntiDiagonal(player))){ // col = 2 is same as n - row - 1 = 3 - 0 - 1 then check anti diagonal 
                return player;
            }
        return 0;
    }
    // we need to check left to right and diagonal
    private boolean checkRow(int row, int player){
        // check if all cells in row are marked by current player
        for(int i = 0; i < n; i++){
            if(board[row][i] != player)
                return false;
        }
        return true;
    }
    // we need to check left to right and diagonal
    private boolean checkCol(int col, int player){
        // check if all cells in row are marked by current player
        for(int i = 0; i < n; i++){
            if(board[i][col] != player)
                return false;
        }
        return true;
    }
    // anti diagonal from back / <- like this 
    private boolean checkAntiDiagonal(int player){
        for(int i = 0; i < n; i++){
            if(board[i][n - i - 1] != player)
                return false;
        }
        return true;
    }
    // check diagonal from back \ <- like this 
    private boolean checkDiagonal(int player){
        for(int i = 0; i < n; i++){
            if(board[i][i] != player)
                return false;
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
