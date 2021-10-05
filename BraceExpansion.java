import java.util.*;
public class BraceExpansion {
    List<String> list = new ArrayList();
    Map<Character, String> map = new HashMap();
    public void dfs(String str, int i, String curr) {
        if (i==str.length()) {
            list.add(curr);
            return;
        }
        
        char x = str.charAt(i);
        
        if (Character.isAlphabetic(x)) {
            dfs(str, i+1, curr+x);
        }
        else {
            if (map.containsKey(x)) {
                String choices = map.get(x);
                for (char choice : choices.toCharArray()) {
                    dfs(str, i+1, curr+choice);
                }
            }
        }
    }
    
    
    public String[] expand(String s) {
        StringBuilder sb = new StringBuilder();
        char index = '0';
        
        int i=0;
        while (i<s.length()) {
            char c = s.charAt(i);
            if (c != '{') {
                sb.append(c);
                i++;
            }
            else {
                StringBuilder choices = new StringBuilder();
                i++;
                char x = c;
                while (i<s.length() && x != '}') {
                    x = s.charAt(i);
                    if (Character.isAlphabetic(x)) {
                        choices.append(x);
                    }
                    i++;
                }
                map.put(++index, choices.toString());
                sb.append(index);
            }
        }
                
        dfs(sb.toString(), 0, "");
        String[] ans = new String[list.size()];
        for (int j=0; j<list.size(); j++) {
            ans[j] = list.get(j);
        }
        Arrays.sort(ans);
        return ans;
    }
}
