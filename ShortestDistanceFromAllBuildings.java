import java.util.*;
class ShortestDistanceFromAllBuildings {
  class Pair {
    int cost;
    int buildingCount;
    Pair (int c, int bc) {
        this.cost = c;
        this.buildingCount = bc;
    }
}

int[][] moves = {{-1,0},{1,0},{0,1}, {0,-1}};

public void generateCosts(int[][] grid, int i, int j, Pair[][] pGrid, Set<String> visited) {
    Queue<int[]> q = new LinkedList();
    q.add(new int[]{i, j});
    int level = 0;
    while (!q.isEmpty()) {
        int size = q.size();
        for (int x=0; x<size; x++) {
            int[] curr = q.poll();
            
            pGrid[curr[0]][curr[1]].cost += level;
            pGrid[curr[0]][curr[1]].buildingCount++;
            
            for (int[] move : moves) {
                int nexti = curr[0] + move[0];
                int nextj = curr[1] + move[1];
                
                if (nexti < 0 || nextj < 0 || nexti >= grid.length || nextj >= grid[0].length || grid[nexti][nextj] != 0 || visited.contains(nexti+","+nextj)) continue;    
                visited.add(nexti+","+nextj);
                q.add(new int[]{nexti, nextj});
            }
        }
        level++;
    }
}

public int shortestDistance(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
   
    Pair[][] pGrid = new Pair[m][n];
    for (int i=0; i<m; i++) {
        for (int j=0; j<n; j++) {
            pGrid[i][j] = new Pair(0, 0);
        }
    }
    int bc =0;
    for (int i=0; i<m; i++) {
        for (int j=0; j<n; j++) {
            if (grid[i][j] == 1) {
                bc++;
                Set<String> visited = new HashSet();
                generateCosts(grid, i, j, pGrid, visited);
            }
        }
    }
    
    int min = Integer.MAX_VALUE;
    for (int i=0; i<m; i++) {
        for (int j=0; j<n; j++) { 
            if (grid[i][j] == 0 && pGrid[i][j].buildingCount == bc) {
                min = Math.min(pGrid[i][j].cost, min);
            }
        }
    }
    
    return min == Integer.MAX_VALUE ? -1 : min;
}
}