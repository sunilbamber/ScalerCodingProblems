package module4_dsa1.arrays.day15_oneDimensional;

public class MaxSumContiguousSubarray {
    /**
     * Problem Description
     * Given an array A of length N, your task is to find the maximum possible sum of any non-empty
     * contiguous subarray.
     *
     * In other words, among all possible subarrays of A, determine the one that yields the
     * highest sum and return that sum.
     *
     * Problem Constraints
     * 1 <= N <= 106
     * -1000 <= A[i] <= 1000
     */
    public int maxSubArray(final int[] A) {

        int currMaxSum = A[0];
        int maxSum = A[0];

        for(int i=1;i<A.length;i++) {
            currMaxSum = currMaxSum +A[i] > A[i] ? currMaxSum+A[i] : A[i];

            if(maxSum < currMaxSum)
                maxSum = currMaxSum;
        }
        return maxSum;
    }
}
