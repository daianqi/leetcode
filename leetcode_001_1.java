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
*/

import java.lang.System;
import java.util.Arrays;
import java.util.Hashtable;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(numbers == null || numbers.length == 0)
            return new int[2];

        int [] nums = numbers.clone(); //learn
        Arrays.sort(numbers); //learn

        int i = 0;
        int j = numbers.length-1;

        while(i < j){
            if(numbers[i]+numbers[j] == target){
                break;
            }
            else if(numbers[i]+numbers[j] < target){
                i++;
            }
            else {
                j--;
            }
        }

        int [] results = {-1,-1};
        for(int k = 0;k < nums.length;k++){
            if(numbers[i] == nums[k] && results[0] == -1){
                results[0] = k+1;
            }
            else if(numbers[j] == nums[k]&& results[1] == -1){   //no same index for same value
                results[1] = k+1;
            }
        }
        Arrays.sort(results);  //save
        return results;
    }
}


