public class GameOfLife {
   
  public int countLiveNeighbours(int i, int j, int[][] board) {
    int count =0;

    if (i-1 >= 0 && Math.abs(board[i-1][j]) == 1) count++;
    if (i-1 >= 0 && j-1 >= 0) {
        if (Math.abs(board[i-1][j-1]) == 1) count++;
    }
    if (i-1 >= 0 && j+1 < board[i].length) {
        if (Math.abs(board[i-1][j+1]) == 1) count++;
    }
    if (i+1 < board.length && Math.abs(board[i+1][j]) == 1) count++;
    if (i+1 < board.length && j-1 >= 0) {
        if (Math.abs(board[i+1][j-1]) == 1) count++;
    }
    if (i+1 < board.length && j+1 < board[i].length) {
        if (Math.abs(board[i+1][j+1]) == 1) count++;
    }
    
    if (j-1 >= 0) {
        if (Math.abs(board[i][j-1]) == 1) count++;
    }
    if (j+1 < board[i].length) {
        if (Math.abs(board[i][j+1]) == 1) count++;
    }
    
    
    return count;
}


public void gameOfLife(int[][] board) {
    for (int i=0; i<board.length; i++) {
        for (int j=0; j<board[i].length; j++) {
            int count = countLiveNeighbours(i,j,board);
            if (board[i][j] == 1) {
                if (count < 2 || count > 3) {
                    //dies
                    board[i][j] = -1;
                }
            }
            else if (board[i][j] == 0) {
                if (count == 3) {
                    // becomes alive
                    board[i][j] = 2; 
                }
            }
        }
    }
    for (int i=0; i<board.length; i++) {
        for (int j=0; j<board[i].length; j++) {
            if (board[i][j] == -1) {
                board[i][j] = 0;
            }
            else if (board[i][j] == 2) {
                board[i][j] = 1;
            }
        }
    }
}
}
