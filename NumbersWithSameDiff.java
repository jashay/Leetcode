import java.util.*;
public class NumbersWithSameDiff {
    List<Integer> list = new ArrayList<>();
    
    public void dfs(int i, int n, int k, String curr) {
        if (n==i) {
            list.add(Integer.parseInt(curr));
            return;
        }
        
        for (int x=0; x<=9; x++) {
            if (x == 0 && i == 0) continue;
            if (i == 0 || Math.abs(x - Character.getNumericValue(curr.charAt(curr.length()-1))) == k) dfs(i+1, n, k, curr+x);
        }
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        dfs(0, n, k, "");
        
        int[] ans = new int[list.size()];
        
        for (int i=0; i<list.size(); i++) ans[i] = list.get(i);
        
        return ans;
    }
}
