package module4.dsa1.arrays.day16_twoDimensional;

/**
 * Problem Description
 * Given a matrix of integers A of size N x M and an integer B.
 * In the given matrix every row and column is sorted in non-decreasing order.
 * Find and return the position of B in the matrix in the given form:
 * If A[i][j] = B then return (i * 1009 + j)
 * If B is not present return -1.
 *
 * Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
 * Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
 * Note 3: Expected time complexity is linear
 * Note 4: Use 1-based indexing
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 1000
 * -100000 <= A[i] <= 100000
 * -100000 <= B <= 100000
 */
public class SearchInSortedMatrix {
    /**
     * Approach: Staircase Search
     * 	1.	Start from the top-right corner of the matrix (i = 0, j = M-1)
     * 	2.	At each step:
     * 	•	If A[i][j] == B → store (i+1)*1009 + (j+1) and continue left to check for smaller j
     * 	•	If A[i][j] > B → move left (j--)
     * 	•	If A[i][j] < B → move down (i++)
     * 	3.	Return the smallest encoded position if found.
     * @param A
     * @param B
     * @return
     */
    public int solve(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;

        int i=0, j=m-1;
        int result = Integer.MAX_VALUE;

        while(i<n && j>=0) {
            if(A[i][j] < B) {
                i++;
            } else if(A[i][j] > B) {
                j--;
            } else {
                int temp = (i+1) * 1009 + (j+1);
                result = Math.min(result, temp);
                j--;
            }
        }
        return result == Integer.MAX_VALUE ? -1:result;
    }
}
