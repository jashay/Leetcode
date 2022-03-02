import java.util.*;
public class BusRoutes {

    public int bfs(Queue<Integer> q, Set<Integer> visited, int target, Map<Integer, List<Integer>> map, int[][] routes) {
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int currStop = q.poll();
                if (currStop == target) return level;
                for (int bus : map.get(currStop)) {
                    if (!visited.add(bus)) continue;
                    for (int stop : routes[bus]) q.add(stop);
                }
            }
            level++;
        }
        return -1;
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if (source == target) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Build graph
        for (int bus = 0; bus<routes.length; bus++) {
            for (int stop : routes[bus]) {
                map.putIfAbsent(stop, new ArrayList<>());
                map.get(stop).add(bus);
            }
        }
    
        Set<Integer> visited = new HashSet<>();
        if (!map.containsKey(source)) return -1;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        
        return bfs(q, visited, target, map, routes);
    }
}
