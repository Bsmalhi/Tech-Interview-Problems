// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
        String s = "42";
        System.out.println("String to int: " + atoi(s));
    }
    public static int atoi(String s){
        if(s.length() == 0)
            return 0;
        int i = 0, ans = 0, sign = 1;
        while(i < s.length() && s.charAt(i) == ' ')
            i++;
        if(i < s.length() && s.charAt(i) == '+'){
            i++;
            sign = 1;
        } else if(i < s.length() && s.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
                        // Check overflow and underflow conditions. 
            if ((ans > Integer.MAX_VALUE / 10) || 
                (ans == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {     
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.    
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans *= 10;
            ans += digit;
            i++;
        }
            
        return sign == -1 ? -ans : ans;
    }
}
