public class MinimumAddToBalanceParanthesis {
  public int minAddToMakeValid(String s) {
        
    int counter = 0, open=0;
    
    for (int i=0; i<s.length(); i++) {
        char c = s.charAt(i);
        
        if (c == '(') {
            open++;
        }
        else {
            if (open > 0) open--;
            else {
                while (open <= 0) {
                    counter++;
                    open++;
                }
                open--;
            }
            
        }
    }
    int close = 0;
    for (int i=s.length()-1; i>=0; i--) {
        char c = s.charAt(i);
        
        if (c == ')') {
            close++;
        }
        else {
            if (close > 0) close--;
            else {
                while (close <= 0) {
                    counter++;
                    close++;
                }
                close--;
            }
        }
    }
    
    return counter;
    
  }
}
