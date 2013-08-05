/*
Median of Two Sorted Arrays.
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

/*
If you want a simpler reduction to equal sized lists, pad the shorter list with an equal number of positive and negative
infinities. If you need an odd number of pads (ie: when the source lists have an odd total), do it with positive infinity
and (since the set size was odd) return the lesser of the two retuned values.
*/

import java.lang.Integer;
import java.lang.Math;
import java.lang.System;

public class leetcode_002  {
    public static int[] pad(int[] array, int size) {
        int diff = size - array.length;
        int[] newArray = new int[size];
        if(diff%2 == 0) {
            int length = 0;
            for(int i = 0;i<diff/2;i++) {
                newArray[length++] = Integer.MIN_VALUE;
            }
            for(int i = 0;i<array.length;i++) {
                newArray[length++] = array[i];
            }
            for(int i = 0 ;i<diff/2;i++) {
                newArray[length++] = Integer.MAX_VALUE;
            }
        } else {
            int length = 0;
            for(int i = 0;i<diff/2;i++) {
                newArray[length++] = Integer.MIN_VALUE;
            }
            for(int i = 0;i<array.length;i++) {
                newArray[length++] = array[i];
            }
            for(int i = 0 ;i<diff/2+1;i++) {
                newArray[length++] = Integer.MAX_VALUE;
            }
        }

        return newArray;
    }

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
        return newArray;
    }

    public static int[] getRight(int[] array) {
        int length = 0;
        if(array.length%2 != 0) {
            length = array.length/2+1;
        } else {
            length = array.length/2;
        }

        int[] newArray = new int[length];                  //diff
        int j = 0;
        for(int i = array.length/2;i<array.length;i++)     //diff
            newArray[j++] = array[i];
        return newArray;
    }

    public static double findMedium(int[] array1, int[] array2) {
        if(array1.length < array2.length) {
            array1 = pad(array1, array2.length);
        }
        if(array1.length > array2.length) {
            array2 = pad(array2,array1.length);
        }
        if(array1.length == 1 && array2.length ==1) {
            return ((double)array1[0]+(double)array2[0])/2;
        }
        if(array1.length == 2 && array2.length ==2) {
            return (Math.max((double)array1[0],(double)array2[0])+Math.min((double)array1[1],(double)array2[1]))/2;
            //if diff between array1 and array2 is odd, get the minimum between the two, not sum divide by 2.
            //not finished, a little bit tedious
        }
        int medium1 = array1[array1.length/2];
        int medium2 = array2[array2.length/2];
        System.out.println("medium1: "+ medium1+"| medium2: "+medium2);
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
        int[] array1 = {1, 4, 6, 10, 18};
        int[] array2 = {1, 7, 13, 45, 58, 69, 100, 180, 300};
//        int[] array1 = {1, 12, 15, 26, 38};
//        int[] array2 = {2, 13, 17, 30, 45};
        System.out.println(findMedium(array1,array2));
    }
}
