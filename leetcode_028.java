/*
Implement strStr().
Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
Rabin-Karp algorithm, KMP algorithm, and the Boyer-Moore algorithm
*/

public class Solution {
    //The brute force method
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(needle == "")    return haystack;   //bug
        for(int i = 0;i<haystack.length()-needle.length()+1;i++) {  //trick
            if(haystack.charAt(i) == needle.charAt(0)) {
                int j = i,q = 0;
                while(q < needle.length() && j < haystack.length()) {
                    if(haystack.charAt(j++) != needle.charAt(q++))  break;
                    if(q == needle.length())    return haystack.substring(i,haystack.length());
                }
            }
        }
        return null;
    }
}
