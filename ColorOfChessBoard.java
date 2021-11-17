class ColorOfChessBoard {
  public boolean squareIsWhite(String coordinates) {
    int col = coordinates.charAt(0) - 'a';
    int row = Character.getNumericValue(coordinates.charAt(1));
    
    if (col %2 == 0) {
        return row % 2 == 0;
    }
    else {
       return row % 2 != 0; 
    }
  }
}