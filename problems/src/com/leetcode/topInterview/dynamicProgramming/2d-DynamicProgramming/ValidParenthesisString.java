class Solution {
    // so this has 2 pointers for tracking leftParanthesis Minimum we can take by counting * as a right Paran ) then decrement
    // another pointer is leftParanthesis Max we can take by counting * as a left Paran then we increment leftMax++;
    // if ever left Max goes negative that means its not a valid paranthesis string
    public boolean checkValidString1(String s) {
        if(s.length() < 1){
            return true;
        }
        int leftMax = 0, leftMin = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                leftMin++;
                leftMax++;
            } else if(c == ')'){
                leftMin--;
                leftMax--;
            } else if(c == '*') {
                leftMin--;
                leftMax++;
            }
            if(leftMax < 0)
                return false;
            if(leftMin < 0)
                leftMin = 0;
        }
        return leftMin == 0;
    }

    // using dfs top down approach
    public boolean checkValidString(String s){
        if(s.length() < 1)
            return true;
        Boolean [][] dp = new Boolean[s.length()][s.length() + 1]; //index & unmatched open parenthesis count pair
        return dfs(s, 0, dp, 0);
    }
    // 3 ways
    private boolean dfs(String s, int i, Boolean [][] dp, int count){
        if(count < 0)
            return false;
        if(i == s.length()){
            return count == 0;
        }
        if(dp[i][count] != null)
            return dp[i][count];
        if(s.charAt(i) == '('){
            dp[i][count] = dfs(s, i + 1, dp, count + 1);
        } else if(s.charAt(i) == ')'){
            dp[i][count] = dfs(s, i + 1, dp, count - 1);
        } else if(s.charAt(i) == '*'){
            dp[i][count] = dfs(s, i + 1, dp, count + 1) || dfs(s, i + 1, dp, count -1) || dfs(s, i + 1, dp, count);
        }
        return dp[i][count];
    }
}






















