import java.util.*;
public class AccountsMerge {
  public void dfs(Map<String, List<String>> graph, Set<String> visited, String email, Set<String> list) {
    list.add(email);
    for (String child : graph.get(email)) {
        if (!visited.contains(child)) {
            visited.add(child);
            dfs(graph, visited, child, list);
        }
    }
}

public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, List<String>> graph = new HashMap();
    Map<String, String> emailToName = new HashMap();
    
    for (List<String> account : accounts) {
        String name = "";
        for (String email : account) {
            if (name == "") {
                name = email;
                continue;
            }
            
            graph.computeIfAbsent(email, x -> new ArrayList()).add(account.get(1));
            graph.computeIfAbsent(account.get(1), x -> new ArrayList()).add(email);
            emailToName.put(email, name);
        }
    }
    Set<String> visited = new HashSet();
    List<List<String>> res = new ArrayList();
    for (String email : graph.keySet()) {
        if (!visited.contains(email)) {
            visited.add(email);
            Set<String> l = new HashSet();
            l.add(email);
            dfs(graph, visited, email, l);
            List<String> list = new ArrayList();
            list.addAll(l);
            Collections.sort(list);
            list.add(0, emailToName.get(email));
            res.add(list);
        }
    }
    return res;
}
}
