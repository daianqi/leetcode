/*
Longest Palindromic Substring.
http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and
there exists one unique longest palindromic substring.
A palindrome is a string which reads the same in both directions. For example, “aba” is a palindome, “abc” is not.
*/

//Dynamic Programming
//aSTRINGa is a palindromic iff STRING is a palindromic
//base case is "a" and "bb"

import java.lang.System;

public class leetcode_005_1 {
    public static String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] record = new boolean[1000][1000];    //genuis
        int longest = 1;
        int longestStart = 0;
        int n = s.length();
        for(int i = 0;i<n;i++) {
            record[i][i] = true;         //base case single character
        }
        for(int i = 0;i<n-1;i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                record[i][i+1] = true;   //base case two characters
                longest = 2;
                longestStart = i;
            }
        }
        for(int len = 3;len<n+1;len++) {
            for(int i = 0;i<n-len+1;i++) {    //confusing
                int j = i+len-1;
                if((s.charAt(i)==s.charAt(j)) && record[i+1][j-1]) {
                    record[i][j] = true;
                    if(longest<len) {
                        longest = len;
                        longestStart = i;
                    }
                }
            }
        }
        return s.substring(longestStart,longestStart+longest);
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("abb"));
    }
}
