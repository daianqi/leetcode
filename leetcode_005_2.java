/*
Longest Palindromic Substring.
http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and
there exists one unique longest palindromic substring.
A palindrome is a string which reads the same in both directions. For example, “aba” is a palindome, “abc” is not.
*/

//expandAround
//case one "aba" expand around single character
//case two "abba" expand around between two characters

import java.lang.System;

public class leetcode_005_2 {
    public static String expandAround(String s, int left, int right) {
        if(s.charAt(left)!=s.charAt(right))  //bug
            return "";
        while(left>=0 && right<=s.length()-1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;         //expand
        }
        return s.substring(left+1,right); //bug
        //substring!!! beginindex included, endindex not included, length(endindex-beginindex)
    }

    public static String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String longest = "";
        for(int i = 0;i<s.length();i++) {
            String result = expandAround(s,i,i);    //expand case one "aba" around character
            if(longest.length() < result.length()) {
                longest = result;
            }
        }
        for(int i = 0;i<s.length()-1;i++) {
            String result = expandAround(s,i,i+1);  //expand case two "abba" between character
            if(longest.length() < result.length()) {
                longest = result;
            }
        }
        return longest;
    }
    public static void main(String[] args) {

        System.out.println(longestPalindrome("abb"));
    }
}
