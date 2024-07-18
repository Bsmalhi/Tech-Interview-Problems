import java.util.*;
class RomanToInteger {
    public static void main(String[] args) {
        String s = "IVII";
        System.out.println("String to int: " + romanToInt(s));
    }
    public static int romanToInt(String s) {
        int ans = 0, i = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        while(i < s.length()){
            // bcoz smaller IV in this I is smaller so V - I will give us right roman number to int 4
            if(i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                ans += map.get(s.charAt(i + 1)) - map.get(s.charAt(i)); 
                i += 2;
            } else {
                ans += map.get(s.charAt(i));
                i += 1;
            }
        }
        return ans;
    }
}
