import java.util.*;
public class LetterCasePermutation {
  public void recursivePut(String s, int i, Set<String> set) {
        
    set.add(s);
    
    if (i >= s.length()) return;
    
    if (Character.isAlphabetic(s.charAt(i))) {
        StringBuilder newString=new StringBuilder(s);

        if (Character.isUpperCase(s.charAt(i))) newString.setCharAt(i, Character.toLowerCase(s.charAt(i)));
        else newString.setCharAt(i, Character.toUpperCase(s.charAt(i)));        

        if (!set.contains(newString.toString())) recursivePut(newString.toString(), i+1, set);
        recursivePut(s, i+1, set);
    }
    else {
        recursivePut(s, i+1, set);
    }
}

public List<String> letterCasePermutation(String s) {
    Set<String> set = new HashSet<>();
    
    recursivePut(s, 0, set);
    
    List<String> ans= new ArrayList<>();
    for (String x : set) {
        ans.add(x);
    }
    return ans;
}
}
