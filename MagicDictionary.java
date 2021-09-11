import java.util.*;
public class MagicDictionary {
  Set<String> set;
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    /** Initialize your data structure here. */
    public MagicDictionary() {
        set = new HashSet<>();
    }
    
    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            set.add(s);
        }
    }
    
    public boolean search(String searchWord) {
        for (int i=0; i<searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            for (int j=0; j<26; j++) {
                char x = alphabet[j];
                if (c==x) continue;
                String temp = searchWord.substring(0, i) + x + searchWord.substring(i+1, searchWord.length());
                if (set.contains(temp)) return true;    
            }
           
        }
            
            
        return false;
    }
}
