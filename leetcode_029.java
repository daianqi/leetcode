/*
Divide Two Integers.
Divide two integers without using multiplication, division and mod operator.
*/

import java.lang.Math;

public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long result = 0;
        while(a >= b) {
            int i = 1;
            while(a >= (b<<i)) {
                i++;
            }
            result |= 1<<(i-1);
            a -= (b<<(i-1));
        }
        return ((dividend ^ divisor) >>> 31 == 1)?-(int)result:(int)result;
        /*
        The signed left shift operator "<<" shifts a bit pattern to the left, and the signed right shift operator ">>"
        shifts a bit pattern to the right. The bit pattern is given by the left-hand operand, and the number of positions
        to shift by the right-hand operand. The unsigned right shift operator ">>>" shifts a zero into the leftmost
        position, while the leftmost position after ">>" depends on sign extension.
        */
    }
}