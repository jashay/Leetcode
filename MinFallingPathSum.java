public class MinFallingPathSum {
  public int minFallingPathSum(int[][] matrix) {
    int[][] dp = new int[matrix.length][matrix[0].length];
    
    for (int i=0; i<matrix.length; i++) {
        for (int j=0; j<matrix[0].length; j++) {
            if (i==0) {
                dp[i][j] = matrix[i][j];
            }
            else {
                dp[i][j] = 0;
            }
        }
    }
    
    for (int i=1; i<matrix.length; i++) {
        for (int j=0; j<matrix[i].length; j++) {
            int temp=0;
            if (j > 0 && j<matrix[i].length-1)
                temp = Math.min(dp[i-1][j-1], dp[i-1][j+1]);
            else if (j>0) {
                temp = dp[i-1][j-1];
            }
            else if (j==0){
                temp = dp[i-1][j+1];
            }
            dp[i][j] = matrix[i][j]+ Math.min(temp, dp[i-1][j]);
        }
    }
    
    int x = dp.length;
    int ans = Integer.MAX_VALUE;
    for (int j=0; j<dp[x-1].length; j++) {
        ans = Math.min(ans, dp[x-1][j]);
    }
    
    return ans;
}
}
