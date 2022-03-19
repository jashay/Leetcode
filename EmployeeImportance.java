import java.util.*;
public class EmployeeImportance {
    class Employee {
        int id;
        int importance;
        List<Integer> subordinates;
    }
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        Queue<Employee> q = new LinkedList<>();
        if (!map.containsKey(id)) return 0;
        q.add(map.get(id));
        
        int ans = 0;
        while (!q.isEmpty()) {
            Employee e = q.poll();
            ans += e.importance;
            for (int c : e.subordinates) {
                if (map.containsKey(c)) q.add(map.get(c));
            }
        }
        return ans;
    }
}
