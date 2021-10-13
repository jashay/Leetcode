import java.util.*;
class AddBinary {
  public String addBinary(String a, String b) {
        
    Stack<Integer> as = new Stack();
    Stack<Integer> bs = new Stack();
    Stack<Integer> res = new Stack();
    
    for (char c : a.toCharArray()) as.push(Character.getNumericValue(c));
    for (char c : b.toCharArray()) bs.push(Character.getNumericValue(c));
    int carry = 0;
    while (!as.isEmpty() && !bs.isEmpty()) {
        int n1 = as.pop();
        int n2 = bs.pop();
        
        if (n1 + n2 + carry == 3) {
            res.push(1);
        }
        else if (n1 + n2 + carry == 2) {
            carry = 1;
            res.push(0);
        }
        else if (n1 + n2 + carry == 1) {
            res.push(1);
            carry = 0;
        }
        else {
            res.push(0);
        }
    }
    
    while (!as.isEmpty()) {
        int n = as.pop();
        if (n+carry == 1) {
            res.push(1);
            carry = 0;
        }
        else {
            res.push(0);
        }
    }
    while (!bs.isEmpty()) {
        int n = bs.pop();
        if (n+carry == 1) {
            res.push(1);
            carry = 0;
        }
        else {
            res.push(0);
        }
    }
    
    if (carry == 1) res.push(1);
    
    StringBuilder sb = new StringBuilder();
    while (!res.isEmpty()) sb.append(res.pop());
    
    return sb.toString();
}
}