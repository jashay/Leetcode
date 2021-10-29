import java.util.*;
class Trie {
  class TrieNode {
      HashMap<Character, TrieNode> map;
      boolean isWord;
      TrieNode() {
          this.map = new HashMap();
          this.isWord = false;
      }
  }
  
  TrieNode t;
  
  /** Initialize your data structure here. */
  public Trie() {
      t = new TrieNode();
  }
  
  /** Inserts a word into the trie. */
  public void insert(String word) {
      TrieNode temp = t;
      for (int i=0; i<word.length(); i++) {
          char c = word.charAt(i);
          temp.map.putIfAbsent(c, new TrieNode());
          temp= temp.map.get(c);
      }
      temp.isWord = true;
  }
  
  /** Returns if the word is in the trie. */
  public boolean search(String word) {
      TrieNode temp = t;
      for (int i=0; i<word.length(); i++) {
          char c = word.charAt(i);
          if (!temp.map.containsKey(c)) return false;
          temp = temp.map.get(c);
      }
      
      return temp.isWord;
  }
  
  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
      TrieNode temp = t;
      for (int i=0; i<prefix.length(); i++) {
          char c = prefix.charAt(i);
          if (!temp.map.containsKey(c)) return false;
          temp = temp.map.get(c);
      }
      return true;
  }
}
