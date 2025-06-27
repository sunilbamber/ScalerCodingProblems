package module4_dsa1.arrays.day15_oneDimensional;

public class ContinuousSumQuery {

    /**
     * Problem Description
     * There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot.
     * When the devotees come to the temple, they donate some amount of coins to these beggars.
     * Each devotee gives a fixed amount of coin(according to their faith and ability) to some
     * K beggars sitting next to each other.
     *
     * Given the amount P donated by each devotee to the beggars ranging from L to R index,
     * where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot
     * at the end of the day, provided they don't fill their pots by any other means.
     * For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B
     *
     * Problem Constraints
     * 1 <= A <= 2 * 105
     * 1 <= L <= R <= A
     * 1 <= P <= 103
     * 0 <= len(B) <= 105
     */
    public int[] solve(int A, int[][] B) {
        /**
         * Approach: Prefix Sum (Difference Array)
         * 	1.	Create a result array of size A + 1 (for easier manipulation with prefix sum).
         * 	2.	For each donation [L, R, P]:
         * 	•	Add P at index L - 1 (0-based)
         * 	•	Subtract P at index R (to mark end of the donation range)
         * 	3.	Do a prefix sum over the result array.
         * 	4.	Ignore the last element and return the first A elements.
         */

        int[] res = new int[A];

        for (int i = 0; i < B.length; i++) {
            int L = B[i][0];
            int R = B[i][1];
            int P = B[i][2];

            res[L - 1] += P;
            if (R < A)
                res[R] -= P;
        }

        for (int i = 1; i < A; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
