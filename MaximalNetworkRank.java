public class MaximalNetworkRank {
  public int maximalNetworkRank(int n, int[][] roads) {
    int[] inDegree = new int[n];
    int[][] pair = new int[n][n];
    for (int[] road : roads) {
        inDegree[road[0]]++;
        inDegree[road[1]]++;
        pair[road[0]][road[1]] = 1;
        pair[road[1]][road[0]] = 1;
    }
    
    int max = 0;
    
    for (int i=0; i<inDegree.length; i++) {
        for (int j=i+1; j<inDegree.length; j++) {
            max = Math.max(max, inDegree[i] + inDegree[j] - pair[i][j]);
        }
    }
    
    return max;
  }
}
