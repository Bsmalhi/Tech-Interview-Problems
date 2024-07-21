class ValidWordAbbrevation{
  /*
  Input: word = "internationalization", abbr = "i12iz4n"
  Output: true
  Explanation: The word "internationalization" can be abbreviated as "i12iz4n" ("i nternational iz atio n").
  */
   public boolean validWordAbbreviation(String word, String abbr) {
      int i = 0, j = 0, digit = 0;
     while(i < word.length() && j < abbr.length()){
       char a = word.charAt(i);
       char b = abbr.charAt(j);
       if(!Character.isDigit(b)){ // if b is not a digit match a & b 
           if(digit > 0){ // if digit is present increment i += digit
             i += digit;
             if(i >= word.length()) // if I out of bounds return false;
               return false;
             a = word.charAt(i);
           }
           if(a != b) return false;
         }
       } else {
         int currNum = (int) abbr.charAt(j) - '0';
         if(digit > 0){
           digit *= 10;
           digit += currNum;
         } else {
           if(currNum == 0)
              return false;
           digit = currNum;
         }
         j++;
       }
     }
    if(digit != 0)
      return digit + i == word.length();
     return i == word.length() && j == abbr.length();
   }
}
