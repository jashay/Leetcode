public class UniquePaths_2 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int flag1 = 0, flag2 = 0;
    int[][] dp = new int[m][n];        
    
    for (int i=0; i<m; i++) {
        for (int j=0; j<n; j++) {
            if (i==0 && j==0) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = 1;
                else 
                    dp[i][j] = 0;
                continue;
            }
            
            if (i==0) {
                if (obstacleGrid[i][j] == 1) flag1 = 1;
                    
                if (flag1 == 1) dp[i][j] = 0;
                else dp[i][j] = dp[0][0];
            }
            else if (j==0) {
                if (obstacleGrid[i][j] == 1) flag2= 1;
                
                if (flag2 == 1) dp[i][j] = 0;
                else dp[i][j] = dp[0][0];
            }
        }
    }
    
    for (int i=1; i<m; i++) {
        for (int j=1; j<n; j++) {
            if (obstacleGrid[i][j] == 0) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
            else {
                dp[i][j] = 0;
            }
        }
    }
    
    return dp[m-1][n-1];
    
  }
}
