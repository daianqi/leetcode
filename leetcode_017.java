/*
4Sum.
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique
quadruplets in the array which gives the sum of target.
For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

import java.lang.Integer;
import java.lang.System;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class leetcode_017 {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> rl = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 4) return rl;
        HashSet<ArrayList<Integer>> rll = new HashSet<ArrayList<Integer>>();   //good boy
        Arrays.sort(num);
        for(int i = 0; i < num.length - 3; i++)
            for(int j = i + 1; j < num.length - 2; j++)
                for(int m = j + 1, n = num.length - 1; m < n;)
                    if(num[m] + num[n] == target - num[i] - num[j]){
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.addAll(Arrays.asList(num[i], num[j], num[m++], num[n--]));       //good boy
                        rll.add(tmp);
                    }
                    else if(num[m] + num[n] < target - num[i] - num[j]) m++;
                    else n--;
        rl.addAll(rll);
        return rl;
    }

    public static void main(String[] args) {
        int[] test = {2,9,-7,4,2,-6,-3,10,-4,0};
        ArrayList<ArrayList<Integer>> result = fourSum(test,3);
        for(ArrayList<Integer> i : result) {
            for(Integer j : i) {
                System.out.print(j + ",");
            }
            System.out.println();
        }
    }
}