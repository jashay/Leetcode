import java.util.*;
public class MinimumKnightMoves {
  public int minKnightMoves(int x, int y) {
    int[][] offsets = {{1, 2}, {2, 1}, {2, -1}, {1, -2},
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{0,0});
    boolean[][] visited = new boolean[605][605];
    int steps = 0;
    while (!q.isEmpty()) {
        int size = q.size();
        
        for (int i=0; i<size; i++) {
            int[] curr = q.poll();
            if (curr[0] == x && curr[1] == y) {
                return steps;
            }
            
             for (int[] offset : offsets) {
                int[] next = new int[]{curr[0] + offset[0], curr[1] + offset[1]};
                
                if (!visited[next[0] + 302][next[1] + 302]) {
                    visited[next[0] + 302][next[1] + 302] = true;
                    q.add(next);
                }
            }
            
        }
        
        steps++;
    }
    return -1;
}
}
