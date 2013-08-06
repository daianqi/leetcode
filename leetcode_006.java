/*
ZigZag Conversion.
0123456789 10 11 12...

0   4   8
1 3 5 7 9
2   6   10

0     6      12
1   5 7   11 13
2 4   8 10   14
3     9      15

0       8           16
1     7 9        15 17
2   6   10    14    18
3 5     11 13       19
4       12          20
*/

import java.lang.StringBuffer;
import java.lang.System;

public class leetcode_006 {

    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(nRows<=1) return s;   //bug
        int zigzagSize = 2*nRows-2;
        StringBuffer result = new StringBuffer();
        for(int i = 0;i<nRows;i++) {
            for(int j = i;;j+=zigzagSize) {
                if(j>=s.length()) break;            //>=  bug
                result.append(s.charAt(j));         //multiple zigzagSize

                int pos = j+zigzagSize-2*i;
                if(i>0 && i<nRows-1 && pos<s.length()) {   //attention, middle ones add more
                    result.append(s.charAt(pos));
                }
            }
        }
        return result.toString();
    }
}

