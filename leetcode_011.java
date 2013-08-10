/*
Container With Most Water.
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are
drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a
container, such that the container contains the most water.
*/

import java.lang.Math;

public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int start = 0;
        int end = height.length-1;
        int maxArea = 0;
        while(start<end) {
            int newArea = (end-start)*Math.min(height[start],height[end]);
            if(newArea>maxArea) maxArea = newArea;
            if(height[start]<height[end])
                start++;
            else
                end--;
        }
        return maxArea;
    }
}
