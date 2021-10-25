public class StrToTree {
  int i = 0;
    
    public TreeNode dfs(String s) {
        if (i >= s.length()) return null;
        
        String strNum = "";
        int sign =1;
        if (s.charAt(i) == '-') {
            i++;
            sign = -1;
        }
        while (i<s.length() && Character.isDigit(s.charAt(i))) {
            strNum += s.charAt(i);
            i++;
        }
        TreeNode root = new TreeNode(sign * Integer.parseInt(strNum));
        
        if (i < s.length() && s.charAt(i) == '(')  {
            i++;
            root.left = dfs(s);
        }
        
        if (i < s.length() && s.charAt(i) == '(')  {
            i++;
            root.right = dfs(s);
        }
        
        i++;
        
        return root;
    }
    
    
    public TreeNode str2tree(String s) {
        return dfs(s);
    }
}
