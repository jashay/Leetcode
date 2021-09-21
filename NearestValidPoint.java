public class NearestValidPoint {
  public int nearestValidPoint(int x, int y, int[][] points) {
        
    int min = Integer.MAX_VALUE;
    int ans=-1;
    for (int i=0; i<points.length; i++) {
        int[] point = points[i];
        if (x == point[0] || y == point[1]) {
            //valid
            int dist = Math.abs(x-point[0]) + Math.abs(y-point[1]);
            if (dist < min) {
                min = dist;
                ans = i;
            }
        }
    }
    
    return ans;
    
  }
}