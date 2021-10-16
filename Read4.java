class Read4 extends Reader4 {
  int index = 0;
  public int read(char[] buf, int n) {
      char[] buf4 = new char[4];
      int curr = read4(buf4);
      while (curr == 4){
          int i, temp = index;
          for (i = temp; i<temp+4; i++) {
              buf[i] = buf4[i-temp];
              if (++index == n) return index;
          }
          
          buf4 = new char[4];
          curr = read4(buf4);
      }
      int temp = index;
      for (int x = temp; x<temp+curr; x++) {
          buf[x] = buf4[x-temp];
          if (++index == n) return index;
      }
      return index;
  }
}