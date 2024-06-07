class LettersCombinations{
    Map<Character, String> digitToChar;
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty())
            return result;
        digitToChar = new HashMap<>();
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "qprs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");
        letterCombinations(digits, result, 0, "");
        return result;
    }
    private void letterCombinations(String digits, List<String> result, int i, String s){
        if(s.length() == digits.length()){
            result.add(new String(s));
            return;
        }
        for (char c : digitToChar.get(digits.charAt(i)).toCharArray())
            letterCombinations(digits, result, i + 1, s + c);
    }
}
