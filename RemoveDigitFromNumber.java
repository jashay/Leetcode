class RemoveDigitFromNumber {
  public String removeDigit(String number, char digit) {
    char[] arr = number.toCharArray();
    boolean flag = false;
    int lastpos = -1;
    StringBuilder sb = new StringBuilder();
    
    for (int i=0; i<arr.length; i++) {
        if (arr[i] == digit) {
            lastpos = i;
            if (!flag && i+1<arr.length && arr[i+1]>arr[i]) {
                flag = true;
                continue;
            }
        }
        sb.append(arr[i]);
    }
    
    if (!flag) {
        sb = new StringBuilder();
        for (int i=0; i<arr.length; i++) if(i != lastpos) sb.append(arr[i]);
        
    }
    return sb.toString();
  }
}