import java.util.*;
class WordBreak { 
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>();
    
    for (String word : wordDict) {
        set.add(word);
    }
    
    boolean[] dp = new boolean[s.length()+1];
    
    dp[0] = true;
    
    for (int i=1; i<s.length()+1; i++) {
        for (int j=0; j<i; j++) {
            if (dp[j] && set.contains(s.substring(j,i))) {
                dp[i] = true;
                break;
            }
        }
    }
    
    return dp[s.length()];
}
}