class ZigZagConversion{
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this
And then read line by line: "PAHNAPLSIIGYIR"
*/
  public String zigZag(String s, int numRows){
    if(numRows == 1)
      return s; // bcoz zig zag can't be done
    List<StringBuilder> list = new ArrayList<>();
    for(int i = 0; i < numRows; i++){
      list.add(new StringBuilder());
    }
    int currRow = 0;
    boolean goingDown = false;
    for(char c: s.toCharArray()){
      list.get(currRow).append(c);
      if(currRow == 0 || currRow == numRows - 1)
        goingDown = !goingDown; // reverse the direction if hits first or last row to form zig zag
      currRow += goingDown ? 1 : -1;
    }
    StringBuilder res = new StringBuilder();
    for(String sb : list){
      res.append(sb);
    }
    return sb.toString();
  }
}
