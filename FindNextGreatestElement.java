public class FindNextGreatestElement {
  public char nextGreatestLetter(char[] letters, char target) {
    int left = 0;
    int right = letters.length;
    while (left<right) {
        int mid = (left+right)/2;
        if (letters[mid] <= target) left = mid+1;
        else right = mid;
    }
    
    return letters[left % letters.length];
  }
}
