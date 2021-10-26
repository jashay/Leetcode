public class MaxSwap {
  public int maximumSwap(int num) {
        
    char[] str = String.valueOf(num).toCharArray();
    int[] lastPos = new int[10];
    
    for (int i=0; i<str.length; i++) {
        lastPos[str[i] - '0'] = i;
    }
    
    for (int i=0; i<str.length; i++) {
        for (int k=9; k>str[i] - '0'; k--) {
            if (lastPos[k] > i) {
                char temp = str[lastPos[k]];
                str[lastPos[k]]= str[i];
                str[i] = temp;
                return Integer.valueOf(new String(str));
            }
        }
    }
    return num;
  }
}
