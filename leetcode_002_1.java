/*
Median of Two Sorted Arrays
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall
run time complexity should be O(log (m+n)).
*/

import java.lang.Integer;
import java.lang.Math;

public class Solution {
    public double findMedianBaseCase(int med, int C[], int n) {
        if (n == 1)
            return (med+C[0])/2.0;

        if (n % 2 == 0) {
            int a = C[n/2 - 1], b = C[n/2];
            if (med <= a)
                return a;
            else if (med <= b)
                return med;
            else /* med > b */
                return b;
        } else {
            int a = C[n/2 - 1], b = C[n/2], c = C[n/2 + 1];
            if (med <= a)
                return (a+b) / 2.0;
            else if (med <= c)
                return (med+b) / 2.0;
            else /* med > c */
                return (b+c) / 2.0;
        }
    }

    public double findMedianBaseCase2(int med1, int med2, int C[], int n) {
        if (n % 2 == 0) {
            int a = (((n/2-2) >= 0) ? C[n/2 - 2] : Integer.MIN_VALUE);
            int b = C[n/2 - 1], c = C[n/2];
            int d = (((n/2 + 1) <= n-1) ? C[n/2 + 1] : Integer.MAX_VALUE);
            if (med2 <= b)
                return (b+Math.max(med2,a)) / 2.0;
            else if (med1 <= b)
                return (b+Math.min(med2,c)) / 2.0;
            else if (med1 >= c)
                return (c+Math.min(med1,d)) / 2.0;
            else if (med2 >= c)
                return (c+Math.max(med1,b)) / 2.0;
            else  /* a < med1 <= med2 < b */
                return (med1+med2) / 2.0;
        } else {
            int a = C[n/2 - 1], b = C[n/2], c = C[n/2 + 1];
            if (med1 >= b)
                return Math.min(med1, c);
            else if (med2 <= b)
                return Math.max(med2, a);
            else  /* med1 < b < med2 */
                return b;
        }
    }

    public double findMedianSingleArray(int A[], int n) {
        assert(n > 0);
        return ((n%2 == 1) ? A[n/2] : (A[n/2-1]+A[n/2])/2.0);
    }

    public int[] getArraySince(int[] A, int index) {
        int[] result = new int[A.length-index];
        int j = 0;
        for(int i = index;i<A.length;i++) {
            result[j++] = A[i];
        }
        return result;
    }

    public double findMedianSortedArrays(int A[], int m, int B[], int n) {
        assert(m+n >= 1);
        if (m == 0)
            return findMedianSingleArray(B, n);
        else if (n == 0)
            return findMedianSingleArray(A, m);
        else if (m == 1)
            return findMedianBaseCase(A[0], B, n);
        else if (n == 1)
            return findMedianBaseCase(B[0], A, m);
        else if (m == 2)
            return findMedianBaseCase2(A[0], A[1], B, n);
        else if (n == 2)
            return findMedianBaseCase2(B[0], B[1], A, m);

        int i = m/2, j = n/2, k;
        if (A[i] <= B[j]) {
            k = ((m%2 == 0) ? Math.min(i - 1, n - j - 1) : Math.min(i, n - j - 1));
            assert(k > 0);
            return findMedianSortedArrays(getArraySince(A,k), m-k, B, n-k);
        } else {
            k = ((n%2 == 0) ? Math.min(m - i - 1, j - 1) : Math.min(m - i - 1, j));
            assert(k > 0);
            return findMedianSortedArrays(A, m-k, getArraySince(B,k), n-k);
        }
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return findMedianSortedArrays(A,A.length,B,B.length);
    }
}