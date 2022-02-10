import java.util.*;
public class MinimumCostConnectCities {
  class Pair {
    int x;
    int cost;
    Pair (int x, int c) {
        this.x = x;
        this.cost = c;
    }
}

public int minimumCost(int n, int[][] connections) {
    if (connections.length < n-1) return -1;
    Map<Integer, List<Pair>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    int total = 0;
    for (int[] conn : connections ) {
        graph.putIfAbsent(conn[0], new ArrayList<>());
        graph.putIfAbsent(conn[1], new ArrayList<>());
        
        graph.get(conn[1]).add(new Pair(conn[0], conn[2]));
        graph.get(conn[0]).add(new Pair(conn[1], conn[2]));
    }
    
    Queue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.cost - b.cost);
    minHeap.add(new Pair(1, 0));
    
    while (!minHeap.isEmpty()) {
        Pair curr = minHeap.poll();
        
        if (!visited.contains(curr.x)) {
            total += curr.cost;
            visited.add(curr.x);
            for (Pair nei : graph.get(curr.x)) {
                minHeap.add(nei);
            }
        }
    }
    
    if (visited.size() < n) return -1;
    
    return total;
}
}
