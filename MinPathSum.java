public class MinPathSum {
  public int minPathSum(int[][] grid) {
    int[][] dp = new int[grid.length][grid[0].length];
    
    for (int i=0; i<grid.length; i++) {
        for (int j=0; j<grid[0].length; j++) {
            if (i==0 && j==0) {
                dp[i][j] = grid[i][j];
            }
            else if (i==0) {
                for (int k=0; k<=j; k++) {
                    dp[i][j] += grid[i][k];
                }
            }
            else if (j==0) {
                for (int k=0; k<=i; k++) {
                    dp[i][j] += grid[k][j];
                }
            }
        }
    }
    
    for (int i=1; i<grid.length; i++) {
        for (int j=1; j<grid[0].length; j++) {
            dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
        }
    }
    
    return dp[grid.length-1][grid[0].length-1];
  }
}
