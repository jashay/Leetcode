class AddStrings {
  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    
    int x1 = num1.length()-1;
    int x2 = num2.length()-1;
    int carry = 0;
    
    while (x1>=0 || x2>=0) {
        int v1 = x1>=0 ? Character.getNumericValue(num1.charAt(x1)) : 0;
        int v2 = x2>=0 ? Character.getNumericValue(num2.charAt(x2)) : 0;
        
        int val = (v1+v2+carry) %10;
        carry = (v1+v2+carry) /10;
        sb.append(val);
        x1--;
        x2--;
    }
    
    if (carry > 0) sb.append(carry);
    
    return sb.reverse().toString();
  }
}