class ValidPalindrome {
  public boolean isPalindrome(String s) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
        if (Character.isAlphabetic(c) || Character.isDigit(c)) sb.append(c);
    }
    System.out.println(sb.toString());
    char[] arr = sb.toString().toCharArray();
    int left = 0, right = arr.length-1;
    
    while (left < right) {
        if (Character.toLowerCase(arr[left]) != Character.toLowerCase(arr[right])) return false;
        left++;
        right--;
    }
    return true;
}
}