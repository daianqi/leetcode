/*
Roman to Integer.
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
*/

import java.lang.System;
import java.util.HashMap;

public class leetcode_013 {
    public static int romanToInt(String s) {
        int[] nums = {1000, 500, 100, 50, 10, 5, 1};
        Character[] symbols = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        HashMap<Character, Integer> table = new HashMap<Character, Integer>();
        for(int i = 0;i<nums.length;i++) {
            table.put(symbols[i],nums[i]);
        }

        int result = 0;
        int i = 0;
        while(i<s.length()) {
            if((i+1)<s.length() && table.get(s.charAt(i)) < table.get(s.charAt(i+1))) {
                result -= table.get(s.charAt(i++));
                continue;
            }
            result += table.get(s.charAt(i++));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("II"));
    }
}


