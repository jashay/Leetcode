import java.util.*;
public class ProductOfEncodedSegments {
  public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
    int p1 = 0, p2 = 0;
    List<List<Integer>> ans = new ArrayList<>();
    
    while (p1 < encoded1.length && p2 < encoded2.length) {
        int minFreq = Math.min(encoded1[p1][1], encoded2[p2][1]);
        int prod = encoded1[p1][0] * encoded2[p2][0];
        
        List<Integer> t = new ArrayList<>();
        t.add(prod);
        t.add(minFreq);
        ans.add(t);
        
        encoded1[p1][1] -= minFreq;
        encoded2[p2][1] -= minFreq;
        
        if (encoded1[p1][1] == 0) p1++;
        if (encoded2[p2][1] == 0) p2++;
    }
    
    List<List<Integer>> res = new ArrayList<>();
    int prevProd = ans.get(0).get(0), freq = ans.get(0).get(1);
    for (int i=1; i<ans.size(); i++) {
        if (ans.get(i).get(0) == prevProd) {
            freq += ans.get(i).get(1);
            continue;
        }
        
        List<Integer> t = new ArrayList<>();
        t.add(prevProd);
        t.add(freq);
        res.add(t);
        
        prevProd = ans.get(i).get(0);
        freq = ans.get(i).get(1);
    }
    List<Integer> t = new ArrayList<>();
    t.add(prevProd);
    t.add(freq);
    res.add(t);
    return res;
}
}
