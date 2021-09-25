public class KnightDialer {
  int[][] moves = {{-2, -1}, {-2, 1}, {2,-1}, {2,1}, {1,2}, {-1,2}, {1,-2}, {-1,-2}};
    
    public int dfs(int[][] grid, int i, int n, int row, int col, int[][][] dp) {
        
        if (row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] == -1) {
            return 0;
        }
        
        if (i==n) {
            dp[i][row][col] = 1;
            return 1;
        }
        
        if (dp[i][row][col] != -1) {
            return dp[i][row][col];
        }
        
        dp[i][row][col] = 0;
        for (int[] move : moves) {
            dp[i][row][col] += dfs(grid, i+1, n, row + move[0], col + move[1], dp);
            dp[i][row][col] %= (int)1e9 + 7;
        }
        return dp[i][row][col];
    }
    
    
    public int knightDialer(int n) {
        
        int[][] grid = {{1,2,3}, {4,5,6}, {7,8,9}, {-1,0,-1}};
        
        int[][][] dp = new int[n+1][4][3];
        
        for (int i=1; i<=n; i++) {
            for (int j=0; j<4; j++) {
                for (int k=0; k<3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        
        int count=0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] >= 0) {
                    count += dfs(grid, 1, n, i, j, dp);
                    count %= (int) 1e9 + 7;
                }
            }
        }
        
        return count;
        
    }
}