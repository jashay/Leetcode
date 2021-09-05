import java.util.*;
public class LetterCombinationsOfPhoneNumber {
  public void dfs(int i, String currString, List<String> ans, String digits, Map<Integer, String> map) {
    if (i >= digits.length()) {
        ans.add(currString);
        return;
    }
    
    char currDigit = digits.charAt(i);
    String chars = map.get(Integer.parseInt(String.valueOf(currDigit)));
    
    for (char c : chars.toCharArray()) {
        dfs(i+1, currString + c, ans, digits, map);
    }
    
}

  public List<String> letterCombinations(String digits) {
      List<String> ans = new ArrayList<>();
      if (digits.length() ==0) return ans;
      Map<Integer, String> map = new HashMap<>();
      map.put(2,"abc");
      map.put(3,"def");
      map.put(4,"ghi");
      map.put(5,"jkl");
      map.put(6,"mno");
      map.put(7,"pqrs");
      map.put(8,"tuv");
      map.put(9,"wxyz");
      
      dfs(0,"", ans, digits, map);

      return ans;
  }
}
