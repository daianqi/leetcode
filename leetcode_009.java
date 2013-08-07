/*
Palindrome Number.
Determine whether an integer is a palindrome. Do this without extra space.
*/

/*  //test origin == reverse
public class Solution {
    public int reverse(int x) {
        int result =0;
        while(x>0) {
            result = result*10 + x%10;
            x /= 10;
        }
        return result;
    }

    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0) return false;
        if(x == reverse(x)) return true;
        else return false;
    }
}
*/

//chop head and tail, level by level
public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0)     return false;
        int div = 1;
        while(x/div>=10) {
            div*=10;
        }
        while(x>0) {
            int l = x/div;
            int r = x%10;
            if(l!=r)    return false;
            x = (x%div)/10;
            div/=100;
        }
        return true;
    }
}
