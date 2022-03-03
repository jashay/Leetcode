import java.util.*;
public class StrobogrammaticNumber_2 {
    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');
        
        Queue<String> q = new LinkedList<>();
        int currLen = 0;
        if (n%2 == 0) {
            currLen = 0;
            q.add("");
        }
        else {
            currLen = 1;
            q.add("1");
            q.add("8");
            q.add("0");
        }
        
        while (currLen < n) {
            currLen += 2;
            int size = q.size();
            for (int i=0; i<size; i++) {
                String number = q.poll();
                for (Map.Entry<Character, Character> entry : map.entrySet()) {
                    if (currLen != n || entry.getKey() != '0') q.add(entry.getKey() + number + entry.getValue());
                }
            }
        }
         
        List<String> ans =new ArrayList<>();
        while (!q.isEmpty()) ans.add(q.poll());
        
        return ans;
    }
}
