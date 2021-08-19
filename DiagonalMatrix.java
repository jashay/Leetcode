import java.util.*;
public class DiagonalMatrix {
  public int[] findDiagonalOrder(int[][] mat) {
    String direction = "up";
    int i=0;
    int j=0;
    int m = mat.length-1, n = mat[0].length-1;
    
    List<Integer> l = new ArrayList<>();
    
    while (l.size() < (m+1)*(n+1)) {
        System.out.println(mat[i][j]+","+i+","+j+","+direction);
        l.add(mat[i][j]);
        
                
        if(direction.equals("up")) {
            if (i-1 < 0) {
                if (j+1 > n) {
                    i+=1;
                }
                else {
                    j+=1;
                }
                direction = "down";
            }
            else if (j+1 > n && i+1 <=m) {
                i+=1;
                direction= "down";
            }
            else {
                j += 1;
                i -= 1;
            }
        }
        else {
            if (i+1 > m && j+1 <= n) { 
                j+=1;
                direction = "up";
            }
            else if (j-1 < 0 && i+1 <= m) {
                i+=1;
                direction = "up";
            }
            else {
                i+=1;
                j-=1;
            }
        }
    }
    
    int[] ans = new int[l.size()];

    for (int x=0; x<l.size(); x++) {
        ans[x] = l.get(x);
    }
    
    return ans;
    
}
}
