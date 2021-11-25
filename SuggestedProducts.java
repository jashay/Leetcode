import java.util.*;
public class SuggestedProducts {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Arrays.sort(products);
    List<List<String>> ans= new ArrayList();
    String curr = "";
    for (int i=0; i<searchWord.length(); i++) {
        curr += searchWord.charAt(i);
        List<String> temp = new ArrayList();
        for (String p : products) {
            if (temp.size() == 3) {
                break;
            }
            if (p.startsWith(curr)) {
                temp.add(p);
            }
        }
        ans.add(temp);
    } 
    return ans;
}
}
