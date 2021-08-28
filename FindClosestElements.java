import java.util.*;
public class FindClosestElements {
  public class Pair {
    int i;
    int d;
    int v;
    
    public Pair(int i, int d, int v) {
        this.i = i;
        this.d = d;
        this.v = v;
    }
}

public List<Integer> findClosestElements(int[] arr, int k, int x) {
    
    List<Pair> list = new ArrayList<>();
    
    for (int i=0; i<arr.length; i++) {
        Pair p = new Pair(i, Math.abs(arr[i]-x), arr[i]);
        list.add(p);
    }
    
    List<Integer> ans=new ArrayList<>();
    
    Collections.sort(list, new Comparator<Pair>() {
        public int compare(Pair p1, Pair p2) {
            if (p1.d == p2.d) {
                return p1.i - p2.i;
            }
            return p1.d - p2.d;
        }
    });
    
    for (int i=0; i<k; i++) {
        ans.add(list.get(i).v);
    }
    
    Collections.sort(ans);
    
    
    return ans;
}
}
