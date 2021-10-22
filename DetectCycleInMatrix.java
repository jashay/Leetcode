import java.util.*;
class DetectCycleInMatrix {
  int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public boolean dfs(char[][] grid, Set<String> visited, int[] prevPos, int[] curr) {        
        if (visited.contains(curr[0]+","+curr[1])) return true;
        
        visited.add(curr[0]+","+curr[1]);
        for (int[] dir : dirs) {
            int[] newPos = new int[] {curr[0]+dir[0], curr[1]+dir[1]};
            if (Arrays.equals(newPos, prevPos)) continue;
            if (newPos[0] <0 || newPos[1] < 0 || newPos[0] >= grid.length || newPos[1] >= grid[0].length) continue;
            if (grid[newPos[0]][newPos[1]] == grid[curr[0]][curr[1]])
                if (dfs(grid, visited, curr, newPos)) return true;
        }
        
        return false;
    }
    
    
    public boolean containsCycle(char[][] grid) {
        Set<String> set = new HashSet();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++){
                if (!set.contains(i+","+j)) 
                    if (dfs(grid, set, new int[]{-1,-1}, new int[]{i,j})) return true;
            }
        }
        
        return false;
    }
}