/*
String to Integer (atoi).
Implement atoi to convert a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as
possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect
on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists
because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable
values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        str = str.trim();
        int max = Integer.MAX_VALUE/10;
        int sign = 0;
        int result = 0;
        for(int i = 0; i< str.length();i++){
            char c = str.charAt(i);
            if(c == '-'){
                if(sign!=0)
                    return 0;
                sign = -1;
                continue;
            }
            if(c== '+'){
                if(sign != 0)
                    return 0;
                sign = 1;
                continue;
            }
            if(c > 57 || c < 48){
                if(sign != -1)
                    return result;
                return -result;
            }
            if(result> max){        //Integer.MAX_VALUE/10 cant overflow
                if(sign != -1)
                    return Integer.MAX_VALUE;
                return Integer.MIN_VALUE;
            }
            result *= 10;

            int s = getDigit(c);
            if(((double)result+s) > ((double)Integer.MAX_VALUE)){    //genuis
                if(sign != -1)
                    return Integer.MAX_VALUE;
                return Integer.MIN_VALUE;
            }
            result +=s;

        }
        if(sign == -1)
            return -result;  //can do so
        return result;
    }
    private int getDigit(char c){
        int digit = c - '0';
        return (digit >= 0 && digit <= 9) ? digit : -1;
    }
}