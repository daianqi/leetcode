/*Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be
less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

import java.lang.System;
import java.util.Hashtable;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for(int i = 0;i < numbers.length;i++) {
            if(!table.containsKey(numbers[i])) {
                table.put(target-numbers[i],i+1);
            } else {
                int tmp = table.get(numbers[i]);
                int index1 = tmp > (i+1)?(i+1):tmp;
                int index2 = tmp <= (i+1)?(i+1):tmp;
                int[] result = new int[2];
                result[0] = index1;
                result[1] = index2;
                return result;
            }
        }
        return null;
    }
}


