import java.util.*;
public class KweakestRows {
  public class Pair {
    int index;
    int count;
    
    public Pair(int i, int c) {
        this.index = i;
        this.count = c;
    }
  }

  public int[] kWeakestRows(int[][] mat, int k) {
      List<Pair> rows = new ArrayList<>();
      int[] ans = new int[k];
      
      for (int i=0;i<mat.length;i++) {
          int rowCount = 0;
          for (int j=0; j<mat[0].length; j++) {
              if (mat[i][j] == 1) {
                  rowCount++;
              }
          }
          rows.add(new Pair(i, rowCount));
      }
      
      Collections.sort(rows, new Comparator<Pair>() {
          public int compare(Pair x, Pair y) {
              if (x.count == y.count) return x.index - y.index;
              
              else return x.count - y.count;
          }
      });
      
      
      for (int x=0; x<k; x++) {
          ans[x] = rows.get(x).index;
      }
      
      return ans;
  }
}
