import java.util.*;
public class RestoreIPAddress {
  List<String> ans = new ArrayList<>();
    
    public void backtrack(String s, String ip, int i, int count) {
        if (count>4) return;
        if (count == 4 && i==s.length()) {
            ans.add(ip);
            return;
        }
            
        for (int x=1; x<4; x++) {
            if (x+i>s.length()) break;
            String str = s.substring(i, x+i);
            if ((str.startsWith("0") && str.length() >1) || (x==3 && Integer.parseInt(str)>255)) continue;
            backtrack(s, ip+str+(count==3 ? "" : "."), i+x, count+1);
        }
    }
    
    
    public List<String> restoreIpAddresses(String s) {
        
        backtrack(s, "", 0, 0);
        return ans;
    }
}
