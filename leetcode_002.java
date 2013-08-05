/*
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall
run time complexity should be O(log (m+n)).
*/

/*
If both size is n and time complexity requirement is logn. Examine the middle element of each array, and throw out the
lower half of the array with the smaller element (since all those must be less than ½ the numbers) and throw out the upper
half of the array with the larger element (since all those must be greater than ½ the numbers).  Now both arrays are still
the same size.  Repeat until you have two elements left. This is your median.  Each step, you eliminate half of the
numbers, so it should have a runtime of O(logn).
*/

import java.lang.Math;
import java.lang.System;

public class leetcode_2  {
    public static int[] getLeft(int[] array) {
        int length = 0;
        if(array.length%2 != 0) {
            length = array.length/2+1;
        } else {
            length = array.length/2;
        }

        int[] newArray = new int[length];        //same
        int j = 0;
        for(int i = 0;i<length;i++)               //same
            newArray[j++] = array[i];
        System.out.println("left "+ newArray.length);
        return newArray;
    }

    public static int[] getRight(int[] array) {
        int length = 0;
        if(array.length%2 != 0) {
            length = array.length/2+1;
        } else {
            length = array.length/2;
        }

        int[] newArray = new int[length];       //diff
        int j = 0;
        for(int i = array.length/2;i<array.length;i++)     //diff
            newArray[j++] = array[i];
        System.out.println("right "+newArray.length);
        return newArray;
    }

    public static double findMedium(int[] array1, int[] array2) {
        if(array1.length == 1 && array2.length ==1) {
            return ((double)array1[0]+(double)array2[0])/2;
        }
        if(array1.length == 2 && array2.length ==2) {
            return (Math.max((double)array1[0],(double)array2[0])+Math.min((double)array1[1],(double)array2[1]))/2;
        }
        int medium1 = array1[array1.length/2];
        int medium2 = array2[array2.length/2];
        if(medium1 == medium2) {
            return medium1;
        }
        if(medium1>medium2) {
            array1 = getLeft(array1);
            array2 = getRight(array2);
            return findMedium(array1,array2);
        } else {
            array1 = getRight(array1);
            array2 = getLeft(array2);
            return findMedium(array1,array2);
        }
    }
    public static void main(String[] args) {
        int[] array1 = {0,1,3,4,5};
        int[] array2 = {1,1,2,2,10};
        System.out.println(findMedium(array1,array2));
    }
}
