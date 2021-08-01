import java.util.*;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> output = new ArrayList<>();
    String[] strsSorted = new String[strs.length];
    Map<String, ArrayList<String>> stringMap = new HashMap<>();
    
    for (int i=0; i<strs.length; i++) {
        char[] cArray = strs[i].toCharArray();
        Arrays.sort(cArray);
        
        strsSorted[i] = new String(cArray);
    }
    
    for (int i=0; i<strs.length; i++) {
        ArrayList<String> tempList = stringMap.getOrDefault(strsSorted[i], new ArrayList<>());
        tempList.add(strs[i]);
        stringMap.put(strsSorted[i], tempList);
    } 
    
    for (String key : stringMap.keySet()) {
        output.add(stringMap.get(key));
    }
    
    return output;
  }
}
