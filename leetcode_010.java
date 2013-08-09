/*
Regular Expression Matching.
Implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ? false
isMatch("aa","aa") ? true
isMatch("aaa","aa") ? false
isMatch("aa", "a*") ? true
isMatch("aa", ".*") ? true
isMatch("ab", ".*") ? true
isMatch("aab", "c*a*b") ? true
*/

//1337
/*
    bool isMatch(const char *s, const char *p) {
        assert(s && p);
        if (*p == '\0') return *s == '\0';

        // next char is not '*': must match current character
        if (*(p+1) != '*') {
            assert(*p != '*');
            return ((*p == *s) || (*p == '.' && *s != '\0')) && isMatch(s+1, p+1);
        }
        // next char is '*'
        while ((*p == *s) || (*p == '.' && *s != '\0')) {
            if (isMatch(s, p+2)) return true;
            s++;
        }
        return isMatch(s, p+2);
    }
*/


import java.lang.System;

public class leetcode_010 {
    public static boolean helper(String s, int a, String p, int b) {
//        System.out.println("0+++"+a+" "+b);
        if(b >= p.length()) {
//            System.out.println("1 "+(a >= s.length()));
            return a >= s.length();
        }
        if(a >= s.length()) {
//            System.out.println("1.5 "+(b >= p.length()));
            if((b+1)<p.length() && p.charAt(b+1)=='*')
                return helper(s,a,p,b+2);
            return (b >= p.length());
        }
        if((b+1)>=p.length()||((b+1)<p.length() && p.charAt(b+1)!='*')) {    //next character is not '*' : must match current character
//            System.out.println("2+++"+a+" "+b);
            return ((p.charAt(b)==s.charAt(a))||(p.charAt(b)=='.' && a<s.length())) && helper(s, a + 1, p, b + 1);
        }
        //next character is '*'
        while((b<p.length()&&a<s.length()&&p.charAt(b)==s.charAt(a))||(b<p.length()&&p.charAt(b)=='.'&&a<s.length())) {
//            System.out.println("3+++"+a+" "+b);
            boolean temp = helper(s,a,p,b+2);
//            System.out.println("* "+temp);
            if(temp) return true;
            a++;
    }
    return helper(s, a, p, b + 2);
}

    public static boolean isMatch(String s, String p) {
        return helper(s,0,p,0);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("a","ab*")?"Yes":"No");
    }
}

