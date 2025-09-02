package module4.dsa1.arrays.day15_oneDimensional;

import java.util.Arrays;

public class MergeSortedOverlappingIntervals {
    /**
     * Problem Description
     * You are given a collection of intervals A in a 2-D array format, where each interval is
     * represented by a pair of integers `[start, end]`. The intervals are sorted based on their
     * start values.
     *
     * Your task is to merge all overlapping intervals and return the resulting set of non-overlapping
     * intervals.
     *
     * Problem Constraints
     * 1 <= len(A) <= 100000.
     * 1 <= A[i][0] <= A[i][1] <= 100000
     *
     * A is sorted based on the start value (A[i][0])
     */

    public int[][] solve(int[][] A) {
        /**
         * Approach: Merge Intervals (Greedy)
         * 	1.	Start with an empty list merged.
         * 	2.	Iterate over each interval in A:
         * 	•	If merged is empty or current interval does not overlap with the last one in merged,
         * 	    append it.
         * 	•	Else, there is overlap, so merge the intervals by updating the end of the last interval.
         * 	3.	Return merged.
         */

        int[][] res = new int[A.length][2];
        int idx = 0; //index for result
        res[0] = A[0];
        for(int i=1;i<A.length;i++) {
            int[] last = res[idx];
            int[] curr = A[i];

            if(curr[0] <= last[1]) { // overlapping exist
                last[1] = Math.max(curr[1], last[1]);
            } else {
                idx++;
                res[idx] = curr;
            }
        }
        return Arrays.copyOf(res, idx+1);
    }
}
