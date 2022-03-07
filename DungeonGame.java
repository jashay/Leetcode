import java.util.*;
public class DungeonGame {
    int[][] dp;
    int rows;
    int cols;
    
    public int findMinHealth(int currCell, int nextRow, int nextCol) {
        if (nextCol >= this.cols || nextRow >= this.rows) return Integer.MAX_VALUE;
        int nextCell = this.dp[nextRow][nextCol];
        return Math.max(1, nextCell - currCell);
    }
    
    public int calculateMinimumHP(int[][] dungeon) {
        this.cols = dungeon[0].length;
        this.rows = dungeon.length;
        
        this.dp = new int[rows][cols];
        int minHealth = Integer.MAX_VALUE;
        
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        
        for (int row = this.rows -1; row>=0; row--) {
            for (int col = this.cols - 1; col>=0; col--) {
                
                int curr = dungeon[row][col];
                
                int rightHealth = findMinHealth(curr, row, col+1);
                int downHealth = findMinHealth(curr, row+1, col);
                int currHealth = Math.min(rightHealth, downHealth);
                
                minHealth = currHealth != Integer.MAX_VALUE ? currHealth : (curr >= 0 ? 1 : 1 - curr);  
                this.dp[row][col] = minHealth;
            }
        }
        return dp[0][0];
    }
}
