import java.util.*;
public class TicTacToe {
  int winner; 
    int[] diagonalStatLeft;
    int[] diagonalStatRight;
    int[][] horizontalStat;
    int[][] verticalStat;
    int n;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        winner = 0;
        this.n = n;
        diagonalStatLeft = new int[2];
        Arrays.fill(diagonalStatLeft, n);
        
        diagonalStatRight = new int[2];
        Arrays.fill(diagonalStatRight, n);
        
        verticalStat = new int[2][n];
        Arrays.fill(verticalStat[0], n);
        Arrays.fill(verticalStat[1], n);
        
        horizontalStat = new int[2][n];
        Arrays.fill(horizontalStat[0], n);
        Arrays.fill(horizontalStat[1], n);
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        
        if (winner == 0) {
            verticalStat[player-1][col] -= 1;
            horizontalStat[player-1][row] -= 1;
            if (row == col) diagonalStatLeft[player-1] -= 1;
            if ((n-1)-row == col) diagonalStatRight[player-1] -=1;
            
            if (verticalStat[player-1][col] == 0 
                || horizontalStat[player-1][row] == 0 
                || diagonalStatLeft[player-1] == 0 
                || diagonalStatRight[player-1] == 0) winner = player;
            
        }
        
        return winner;
    }
}
