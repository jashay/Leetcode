public class WallsAndGates {
  
  int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    
  public void wallsAndGates(int[][] rooms) {
      Queue<int[]> q = new LinkedList();
      
      for (int i=0; i<rooms.length; i++) {
          for (int j=0; j<rooms[0].length; j++) {
              if (rooms[i][j] == 0) {
                  q.add(new int[]{i,j});
              }
          }
      }
      
      while (!q.isEmpty()) {
          int[] curr = q.poll();
          
          for (int[] dir : directions) {
              int nexti = curr[0]+dir[0];
              int nextj = curr[1]+dir[1];
              
              if (nexti<0 || nextj<0 || nexti>=rooms.length || nextj>=rooms[0].length || rooms[nexti][nextj] != Integer.MAX_VALUE) continue;
              rooms[nexti][nextj] = rooms[curr[0]][curr[1]]+1;
              q.add(new int[]{nexti,nextj});
          }
      }
  }
}
