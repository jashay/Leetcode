class ZigZagConversion {
  public String convert(String s, int numRows) {
    String[] sArray = new String[numRows];
    for (int i=0; i<sArray.length; i++) {
        sArray[i] = "";
    }
    int i=0;
    int flag=1;
    
    if (numRows == 1) {
        return s;
    }
    
    
    for (char c : s.toCharArray()) {
        sArray[i] += c;
        
        if (i==numRows-1) {
            flag = -1;
        }
        else if (i==0) {
            flag = 1;
        }
        
        if (flag == 1) i++;
        else if (flag == -1) i--;
    }
     
    StringBuilder sb = new StringBuilder();
    
    for (String x : sArray) {
        sb.append(x);
    }
    
    
    return sb.toString();
  }
}