/*
Reverse Integer.
Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
*/

public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean neg = (x<0)?true:false;
        if(neg) x*=-1;
        int result =0;
        while(x>0) {
            result = result*10 + x%10;
            x /= 10;
        }
        return neg?(result*-1):result;
    }
}
