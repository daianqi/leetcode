/*
Letter Combinations of a Phone Number.
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.

1: ???  2: abc  3: def
4: ghi  5: jkl  6: mno
7: pqrs 8: tuv  9: wxyz
*: +    0:      \: #

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

import java.lang.Character;
import java.lang.String;
import java.lang.System;
import java.util.ArrayList;
import java.util.HashMap;

public class leetcode_018 {
    public static ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Character,String> table = new HashMap<Character, String>();
        table.put('2',"abc");
        table.put('3',"def");
        table.put('4',"ghi");
        table.put('5',"jkl");
        table.put('6',"mno");
        table.put('7',"pqrs");
        table.put('8',"tuv");
        table.put('9',"wxyz");

        ArrayList<String> temp = new ArrayList<String>();
        for(int i = 0;i<digits.length();i++) {
            String newArray = table.get(digits.charAt(i));
            temp.add(newArray);
        }

        ArrayList<String> newResult = new ArrayList<String>();
        ArrayList<String> oldResult = new ArrayList<String>();
        newResult.add("");

        for(int i = 0;i<temp.size();i++) {
            for(int j = 0;j<temp.get(i).length();j++) {
                for(String str : newResult) {
                    oldResult.add(str+temp.get(i).charAt(j));
                }
            }
            newResult = oldResult;
            oldResult = new ArrayList<String>();

        }
        return newResult;
    }

    public static void main(String[] args) {
        String str = "23";
        ArrayList<String> result = letterCombinations(str);
        for(String s : result) {
            System.out.println(s);
        }
    }
}