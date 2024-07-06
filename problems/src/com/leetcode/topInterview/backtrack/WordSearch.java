class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        // Set<Character> visited = new HashSet<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(dfs(board, word, i, j, 0))
                    return true;
            }
        } 
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int index){
        if(index >= word.length()) // found word as index is now >= word len
            return true;
        if(i >= board.length || i < 0 || j < 0 || j >= board[0].length || board[i][j] == '.' || 
            word.charAt(index) != board[i][j])
                return false;
        // mark visited
        board[i][j] = '*';
        
        boolean exists = dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) ||
                dfs(board, word, i, j - 1, index + 1);

        board[i][j] = word.charAt(index);
        return exists;
    }
}
