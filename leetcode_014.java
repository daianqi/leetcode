/*
Longest Common Prefix.
Write a function to find the longest common prefix string amongst an array of strings.
*/

import java.lang.System;

public class leetcode_014 {
    public static String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String temp = "";
        for(int i = 0;i<strs[0].length();i++) {
            temp += strs[0].charAt(i);
            for(int j = 1;j<strs.length;j++) {
                if(i==strs[j].length() || temp.charAt(temp.length()-1) != strs[j].charAt(i)) {
                    return temp.substring(0,temp.length()-1);
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        String[] array = {"ab","abcc"};
        System.out.println(longestCommonPrefix(array));

    }
}