import java.util.*;
class SubdomainVisitCount {
  public List<String> subdomainVisits(String[] cpdomains) {
        
    Map<String, Integer> map = new HashMap<>();
    
    for (String pair : cpdomains) {
        String[] p = pair.split(" ");
        int count = Integer.parseInt(p[0]);
        String domain = p[1];
        String[] arr = domain.split("\\.");
        String curr = "";
        for (int i= arr.length-1; i>=0; i--) {
            curr = arr[i] + (curr.equals("") ? "" : ".") + curr;
            map.put(curr, map.getOrDefault(curr, 0) + count);
        }
        
    }
    
    List<String> ans = new ArrayList<>();
    for (String key : map.keySet()) {
        int count = map.get(key);
        ans.add(String.valueOf(count)+" "+key);
    }
    
    return ans;
}
}