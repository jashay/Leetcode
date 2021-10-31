import java.util.*;
class MaxMinPath {
  class Pair {
    int[] pos;
    int cost;
    
    Pair(int[] p, int c) {
        this.pos = p;
        this.cost = c;
    }
}

int[][] moves = {{0,1},{1,0},{-1,0}, {0,-1}};

public int maximumMinimumPath(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    Set<String> visited = new HashSet();
    Queue<Pair> q = new PriorityQueue<>((a,b) -> b.cost - a.cost);
    q.add(new Pair(new int[]{0,0},grid[0][0]));
    int min = Integer.MAX_VALUE;
    while (!q.isEmpty()) {
        Pair curr = q.poll();
        int i = curr.pos[0];
        int j = curr.pos[1];
        min = Math.min(min, curr.cost);
        visited.add(i+","+j);
        
        if (i==m-1 && j == n-1) return min;
        
        for (int[] mo : moves) {
            int nexti = i+mo[0];
            int nextj = j+mo[1];
            
            if (nexti <0 || nextj < 0 || nexti>=m || nextj >= n || visited.contains(nexti+","+nextj)) continue;
            
            q.add(new Pair(new int[]{nexti, nextj}, grid[nexti][nextj]));
        }
    }

    
    return -1;
}
}