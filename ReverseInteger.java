class ReverseInteger {
  public int reverse(int x) {
    int max = Integer.MAX_VALUE;
    StringBuilder sb = new StringBuilder();
    int flag = x<0 ? -1 : 1;
    x = Math.abs(x);
    while (x>0) {
        sb.append(x%10);
        x = x/10;
    }
    
    int n = sb.length()-1;
    int ans = 0;
    for (int i=n; i>=0; i--) {
        ans += Character.getNumericValue(sb.charAt(i)) * Math.pow(10, n-i);
    }
    
    if (ans >= max) return 0;
    
    return flag == -1 ? -1*ans : ans;
}
}