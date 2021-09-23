import java.util.*;
public class LetterCombinationsOfPhoneNumber {
  private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    
    List<String> list = new ArrayList();
    
    public void backtrack(String digits, int cur, String s) {
        
        if (cur == digits.length()) {
            list.add(s);
            return;
        }
        
        String alphabets = letters.get(digits.charAt(cur));
        for (char c : alphabets.toCharArray()) {
            backtrack(digits, cur+1, s+c);
        }
        
        return;
    }
    
    
  public List<String> letterCombinations(String digits) {

      backtrack(digits, 0, "");
      if (list.size() > 1)
          return list;
      else
          return new ArrayList<>();
      
  }
}
