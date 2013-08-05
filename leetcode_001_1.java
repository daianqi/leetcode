/*
Two Sum
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be
less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

/*
sort first and then use two index at the beginning and the end
not so good if you want the original index back
*/

import java.lang.System;
import java.util.Arrays;
import java.util.Hashtable;

public class Solution {
    public int findIndex(int[] array, int value) {
        for(int i = 0;i<array.length;i++) {
            if(array[i] == value)
                return i+1;
        }
        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] backup = new int[numbers.length];
        for(int i = 0;i<backup.length;i++)
            backup[i] = numbers[i];
        Arrays.sort(numbers);
        int i = 0;
        int j = numbers.length-1;
        while(i<j) {
            if((numbers[i]+numbers[j]) == target) {
                int[] result = new int[2];
                result[0] = findIndex(backup,numbers[i]);
                result[1] = findIndex(backup,numbers[j]);
                if(result[0]>result[1]) {
                    int temp = result[0];
                    result[0] = result[1];
                    result[1] = temp;
                }
                return result;
            }
            if(numbers[i]+numbers[j]>target)
                j--;
            else
                i++;
        }
        return null;
    }
}


