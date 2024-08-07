class ExpressionAddOperator {
    /**
    Given a string num with digits and int target return all possibilities to insert the binary operatior
     */
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if(num.length() < 1)
            return result;
        helperDfs(result, "", num, target, 0, 0, 0);
        return result;
    }
    private void helperDfs(List<String> result, String path, String num, int target, int pos, long currValue, long lastNum){
        if(num.length() == pos){
            if(currValue == target)
                result.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            // Avoid numbers with leading zeros
            if(i != pos && num.charAt(pos) == '0')
                break;
            // Parse the current number
            Long currNum = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                // first num in expression
                helperDfs(result, path + currNum, num, target, i + 1, currNum, currNum);
            } else {
                // Add '+'
                helperDfs(result, path + "+" + currNum, num, target, i + 1, currValue + currNum, currNum);
                // Add '-'
                helperDfs(result, path + "-" + currNum, num, target, i + 1, currValue - currNum, -currNum);
                // Add '*'
                helperDfs(result, path + "*" + currNum, num, target, i + 1, currValue - lastNum + lastNum * currNum, lastNum * currNum);
            }
        }
    }
}
