package module4.dsa1.arrays.day17_ArraysLabSession;

import java.util.Arrays;

public class NextPermutation {
    /**
     * Problem Description
     * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
     * If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.
     * NOTE:
     * The replacement must be in-place, do not allocate extra memory.
     * DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
     *
     *
     * Problem Constraints
     * 1 <= N <= 5 * 105
     * 1 <= A[i] <= 109
     */

    public static void permutation(int[] A) {
        /**
         * Next Permutation Algorithm (In-Place)
         *
         * Steps:
         * 	1.	Find the pivot (first decreasing number from the right)
         * 	•	Let i be the largest index such that A[i] < A[i + 1].
         * 	•	If no such i exists, the array is the last permutation → reverse it to get the first.
         * 	2.	Find the rightmost number greater than A[i]
         * 	•	Find index j such that A[j] > A[i], where j > i.
         * 	3.	Swap A[i] and A[j]
         * 	4.	Reverse the subarray from i+1 to end
         */
        int n=A.length;
        int i=n-2;

        while(i>=0 && A[i] >= A[i+1])
            i--;

        if(i>=0) {
            int j=n-1;
            while(A[j] <= A[i])
                j--;

            swap(A, i, j);
        }
        reverse(A, i+1, n-1);

    }

    private static void reverse(int[] a, int left, int right) {
        while(left<=right) {
            swap(a, left, right);
            left++;right--;
        }

    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {251, 844, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 891, 991};
        permutation(A);
        System.out.println("Next permutation: " + Arrays.toString(A)); // [1, 3, 2]

        int[] B = {3, 2, 1};
        permutation(B);
        System.out.println("Next permutation: " + Arrays.toString(B)); // [1, 2, 3]
    }
}
