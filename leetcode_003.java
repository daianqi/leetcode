/*
Longest Substring Without Repeating Characters.
http://leetcode.com/2011/05/longest-substring-without-repeating-characters.html
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring
without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with
the length of 1.
*/

/*
When you have found a repeated character (let’s say at index j), it means that the current substring (excluding the repeated
character of course) is a potential maximum, so update the maximum if necessary. It also means that the repeated character
must have appeared before at an index i, where i is less than j.
Since you know that all substrings that start before or at index i would be less than your current maximum, you can safely
start to look for the next substring with head which starts exactly at index i+1.
Therefore, you would need two indices to record the head and the tail of the current substring. Since i and j both traverse
at most n steps, the worst case would be 2n steps, which the run time complexity must be O(n).
*/

import java.lang.Math;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0, j = 0;
        boolean[] record = new boolean[256];
        int maxLength = 0;
        while(j<s.length()) {
            if(record[s.charAt(j)] == false) {
                record[s.charAt(j)] = true;     //mark and move tail
                j++;
            } else {
                maxLength = Math.max(maxLength, j - i);
                while(s.charAt(i) != s.charAt(j)) {
                    record[s.charAt(i)] = false;    //unmark and move head
                    i++;
                }
                i++;
                j++;
            }
        }
        maxLength = Math.max(maxLength, j - i);     //bug

        return maxLength;
    }
}


