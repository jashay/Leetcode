import java.util.*;
class AddAndSearchWord {
  class TrieNode {
    Map<Character, TrieNode> map;
    boolean isWord;
    TrieNode() {
        map = new HashMap();
        isWord = false;
    }
}

TrieNode root;
public AddAndSearchWord() {
    root = new TrieNode();
}

public void addWord(String word) {
    TrieNode temp = root;
    for (int i=0; i<word.length(); i++) {
        char c = word.charAt(i);
        
        if (!temp.map.containsKey(c)) {
           temp.map.put(c, new TrieNode()); 
        }
        temp = temp.map.get(c);
    }
    temp.isWord = true;
}

public boolean search(String word) {
    return searchInNode(word, root);
}

public boolean searchInNode(String word, TrieNode node) {
    TrieNode temp = node;
    for (int i=0; i<word.length(); i++) {
        char c = word.charAt(i);
        if (c == '.') {
            for (char x : temp.map.keySet()) {
                if (searchInNode(word.substring(i+1), temp.map.get(x))) return true;
            }
            return false;
        }
        else {
            if (temp.map.containsKey(c)) {
                temp = temp.map.get(c);
            }
            else return false;
        }
    }
    return temp.isWord;
}
}