package module4.dsa1.arrays.day16_twoDimensional;

public class FirstMissingInteger {
    /**
     * Problem Description
     * Given an unsorted integer array, A of size N. Find the first missing positive integer.
     * Note: Your algorithm should run in O(n) time and use constant space.
     *
     * Problem Constraints
     * 1 <= N <= 1000000
     * -109 <= A[i] <= 109
     * @param A input
     * @return result
     */
    public int firstMissingPositive(int[] A) {

        /**
         * Algorithm: Index Placement
         * 	1.	Place each number in its correct index:
         * 	•	i.e., try to place 1 at index 0, 2 at index 1, …, n at index n-1.
         * 	2.	Loop through the array:
         * 	•	While A[i] is in the range 1 to n, and A[i] != A[A[i] - 1], swap A[i] with A[A[i] - 1].
         * 	3.	Finally, loop through the array:
         * 	•	The first index i where A[i] != i + 1 is the answer → i + 1.
         * 	4.	If all values are correct, return n + 1.
         */

        int n = A.length;
        for(int i=0;i<n;i++) {
            while(A[i]>0 && A[i] <= n && A[i] != A[A[i]-1]) {
                int correctIdx = A[i]-1;
                int temp = A[i];
                A[i] = A[correctIdx];
                A[correctIdx] = temp;
            }
        }

        for(int i=0;i<n;i++) {
            if(A[i] != i+1) {
                return i+1;
            }
        }
        return n+1;
    }
}
