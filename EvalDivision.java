import java.util.*;
class EvalDivision {
    
    class Pair {
        double val;
        String name;
        
        Pair(double v, String n) {
            this.val = v;
            this.name = n;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, List<Pair>> map = new HashMap<>();
        
        for (int i=0; i<values.length; i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            map.putIfAbsent(first, new ArrayList<>());
            map.putIfAbsent(second, new ArrayList<>());
            
            map.get(first).add(new Pair(values[i], second));
            map.get(second).add(new Pair(1/values[i], first));
        }
        
        double[] ans = new double[queries.size()];
        
        for (int i=0; i<queries.size(); i++) {
            List<String> query = queries.get(i);
            String f = query.get(0);
            String s = query.get(1);
            
            if (!map.containsKey(f) || !map.containsKey(s)) ans[i] = -1;
            else {
                
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(1, f));
                Set<String> visited = new HashSet<>();
                ans[i] = -1;
                while (!q.isEmpty()) {
                    Pair curr = q.poll();
                    double val = curr.val;
                    String name = curr.name;
                    visited.add(name);
                    if (name.equals(s)) {
                        ans[i] = val;
                        break;
                    }
                    
                    for (Pair nei : map.get(name)) {
                        if (visited.contains(nei.name)) continue;
                        
                        q.add(new Pair(nei.val*val, nei.name));
                    }
                    
                }
                
            }
        }
        return ans;
    }
}