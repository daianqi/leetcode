/*
3Sum.
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the
array which gives the sum of zero.
*/

import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> arrayAll = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<num.length;i++) {
            if(i>0 && num[i] == num[i-1])   continue;   //remove duplicate from array
            for(int left = i+1, right = num.length-1;left<right;) {
                if(num[i]+num[left]+num[right] == 0) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[left]);
                    temp.add(num[right]);
                    if(arrayAll.indexOf(temp) == -1) {
                        arrayAll.add(temp);
                    }
                    do{left++;} while(left<right && num[left] == num[left-1]);      //remove duplicate
                    do{right--;} while(left<right && num[right] == num[right+1]);   //remove duplicate
                } else if (num[i]+num[right]+num[left] < 0)
                    left++;
                else
                    right--;
            }
        }
        return arrayAll;
    }
}