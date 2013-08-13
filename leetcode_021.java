/*
Generate Parentheses.
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public void recursive(int left, int right, String s, ArrayList<String> array) {
        if(left>0) {
            recursive(left-1,right,s+"(",array);
        }
        if(left<right) {
            recursive(left,right-1,s+")",array);
        }
        if(right == 0) {
            array.add(s);
        }
    }

    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        recursive(n,n,"",result);
        return result;
    }
}