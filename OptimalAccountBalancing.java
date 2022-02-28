import java.util.*;
public class OptimalAccountBalancing {
    int min = Integer.MAX_VALUE;
    public int dfs(int k, List<Integer> l) {
        if (k == l.size()) return 0;
        int curr = l.get(k);
        
        if (curr == 0) {
            return dfs(k+1, l);
        }
        for (int i=k+1; i<l.size(); i++) {
            int next = l.get(i);
            if (curr * next < 0) {
                l.set(i, curr + next);
                min = Math.min(min, 1 + dfs(k+1, l));
                l.set(i, next);
                
                if (curr + next == 0) break;
            }
        }
        
        return min;
        
    }
    
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] t : transactions) {
            int to = t[1];
            int from = t[0];
            int amt = t[2];
            
            map.put(to, map.getOrDefault(to, 0) + amt);
            map.put(from, map.getOrDefault(from, 0) - amt);
        }
        List<Integer> list = new ArrayList<>();
        for (int v : map.values()) {
            if (v != 0) {
                list.add(v);
            }
        }
        
        return dfs(0, list);
    }
}
