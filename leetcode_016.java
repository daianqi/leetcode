/*
3Sum Closest.
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return
the sum of the three integers. You may assume that each input would have exactly one solution.
For example, given array S = {-1 2 1 -4}, and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int diff = Integer.MAX_VALUE;
        int finalSum = 0;
        Arrays.sort(num);
        for(int i = 0;i<num.length;i++) {
            for(int left = i+1,right = num.length-1;left<right;) {
                int sum = num[i]+num[left]+num[right];
                if(sum == target)   return sum;
                if(Math.abs(sum-target)<diff) {
                    diff = Math.abs(sum-target);
                    finalSum = sum;
                }
                if(sum>target)
                    right--;
                else
                    left++;
            }
        }
        return finalSum;
    }
}