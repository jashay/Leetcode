public class CountNegativeInMatrix {
  public int countNegatives(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    int count = 0;
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            if (mat[i][j] < 0) {
                count += m-j;
                break;
            }
        }
    }
    return count;
}
}
