import java.util.*;
class WordBreak2 {
  public List<String> dfs(String s, Set<String> set, int start, String curr) {
      
      List<String> ans = new ArrayList();
      if (start == s.length()) {
          ans.add(curr);
          return ans;
      }
      
      for (int end = start+1; end<=s.length(); end++) {
          if (set.contains(s.substring(start, end))) {
              List<String> temp = dfs(s, set, end, curr + (curr=="" ? "": " ") + s.substring(start, end));
              for (String str : temp) {
                  ans.add(str);
              }
          }
      }
  
      return ans;
  }
  
  public List<String> wordBreak(String s, List<String> wordDict) {
      return dfs(s, new HashSet(wordDict), 0, "");
  }
}