import java.util.*;
public class NumberOfBoomerangs {
  public int getDistance(int[] a, int[] b) {
    int dx = a[0] - b[0];
    int dy = a[1] - b[1];

    return dx*dx + dy*dy;
}

public int numberOfBoomerangs(int[][] points) {
    int n = points.length;
    if (n < 3) return 0;
    int ans = 0;
    for (int i=0; i<points.length; i++) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j=0; j<points.length; j++) {
            
            if (i==j) continue;
            
            int d = getDistance(points[i], points[j]);
            map.put(d, map.getOrDefault(d, 0)+1);
            
        }
        
        for (int key : map.keySet()) {
            int val = map.get(key);
            ans += val * (val-1);
        }
    }
    
    return ans;
}
}
