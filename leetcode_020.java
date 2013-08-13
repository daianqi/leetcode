/*
Valid Parentheses.
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> stk = new Stack();
        for(int i = 0;i<s.length();i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stk.push(s.charAt(i));
            if(s.charAt(i) == ')') {
                if(!stk.isEmpty() && stk.peek() == '(') stk.pop();
                else return false;
            }
            if(s.charAt(i) == ']') {
                if(!stk.isEmpty() && stk.peek() == '[') stk.pop();
                else return false;
            }
            if(s.charAt(i) == '}') {
                if(!stk.isEmpty() && stk.peek() == '{') stk.pop();
                else return false;
            }
        }
        if(stk.isEmpty()) return true;
        else return false;
    }
}