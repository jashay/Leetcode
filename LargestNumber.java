public class LargestNumber {
  public String largestNumber(int[] nums) {
        
    if (nums== null || nums.length == 0) return "";
    
    List<String> list = new ArrayList();
    StringBuilder sb = new StringBuilder();
    for (int n : nums)
        list.add(String.valueOf(n));
    
    Collections.sort(list, new Comparator<String>() {
        public int compare(String a, String b) {
            String s1 = a+b;
            String s2 = b+a;
            
            return s2.compareTo(s1);
        }
    });
    
    
    if (list.get(0).charAt(0) == '0') {
           return "0";
    }
    for (String x : list) {
        sb.append(x);
    }
    
    
    return sb.toString();
}
}
