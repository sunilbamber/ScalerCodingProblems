package module4.dsa1.arrays.day16_twoDimensional;

public class SumOfAllSubmatrices {
    /**
     * Problem Description
     * Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.
     *
     * Problem Constraints
     * 1 <= N <=30
     * 0 <= A[i][j] <= 10
     * @param A
     * @return result
     */
    public int solve(int[][] A) {

        /**
         *Key Insight:
         *
         * Every element A[i][j] contributes to multiple submatrices. Specifically,
         * the number of submatrices that include element A[i][j] is:
         *      (i + 1) * (j + 1) * (N - i) * (N - j)
         * 	•	(i + 1) = choices for top row
         * 	•	(j + 1) = choices for left column
         * 	•	(N - i) = choices for bottom row
         * 	•	(N - j) = choices for right column
         */

        int n = A.length;
        long totalSum = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                long topLeftOpt = (i+1) * (j+1);
                long bottomRight = (n-i) * (n-j);
                totalSum += (long) (A[i][j] * topLeftOpt *bottomRight);
            }
        }
        return (int)totalSum;
    }
}
