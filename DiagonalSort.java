import java.util.*;
public class DiagonalSort {
  public int[][] diagonalSort(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int i=m-1, j=0;
    
    int[][] ans = new int[m][n];
    
    while (i>=0) {
        int x = i, y = j;
        Queue<Integer> minHeap = new PriorityQueue<>();
        while (x<m && y<n) {
            minHeap.add(mat[x][y]);
            x++;
            y++;
        }
        x = i; y=j;
        while (x<m && y<n) { 
            ans[x][y] = minHeap.poll();
            x++;
            y++;
        }
        i--;
    }
    i=0;
    while (j<=n-1) {
        int x = i, y = j;
        Queue<Integer> minHeap = new PriorityQueue<>();
        while (x<m && y<n) {
            minHeap.add(mat[x][y]);
            x++;
            y++;
        }
        x = i; y=j;
        while (x<m && y<n) { 
            ans[x][y] = minHeap.poll();
            x++;
            y++;
        }
        j++;
    }
    
    
    return ans;
    
}
}
