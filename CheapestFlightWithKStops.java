import java.util.*;
public class CheapestFlightWithKStops {
  private class Pair {
    int dest;
    int price;
    
    private Pair(int dest, int price) {
        this.dest = dest;
        this.price = price;
    }
}

private void dfs(Map<Integer, Set<Pair>> map, int curr, int dst, int count, int k, int[] minPrice, int currPrice, int[] visited) {
    
    
    if (curr == dst) {
        minPrice[0] = Math.min(minPrice[0], currPrice);
        return;
    }
    if (k+1 == count) return;
    visited[curr] = 1;
    if (map.containsKey(curr)) {
        Set<Pair> set = map.get(curr);            
        for (Pair pair : set) {
            if (visited[pair.dest] == 0) {
                if (currPrice+pair.price > minPrice[0]) continue;
                
                dfs(map, pair.dest, dst, count+1, k, minPrice, currPrice+pair.price, visited);
            }
        }
    }
    visited[curr] = 0;
}


public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int[] minPrice = new int[1];
    minPrice[0] = Integer.MAX_VALUE;
    
    Map<Integer, Set<Pair>> map = new HashMap<>();
    
    for (int[] flight : flights) {
        Set<Pair> temp;
        if (map.containsKey(flight[0])) {
            temp = map.get(flight[0]);
        }
        else {
            temp = new HashSet<>();
        }
        temp.add(new Pair(flight[1], flight[2]));
        map.put(flight[0], temp);
    }
    
    int[] visited = new int[n];
    
    for (int i=0; i<n; i++) {
        visited[i] = 0;
    }
    
    dfs(map, src, dst, 0, k, minPrice, 0, visited);
        
    if (minPrice[0] == Integer.MAX_VALUE) {
        return -1;
    }
    return minPrice[0];
  }
}
