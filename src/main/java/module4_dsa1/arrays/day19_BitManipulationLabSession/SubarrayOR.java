package module4_dsa1.arrays.day19_BitManipulationLabSession;

/**
 * Problem Description
 * You are given a binary array A of length N where each element is either
 *  0 or 1.
 * Your task is to count the number of subarrays where the bitwise OR of all
 * the elements in the subarray is 1.
 * Problem Constraints
 * 1 <= N <= 104
 * A[i] is either 0 or 1
 */
public class SubarrayOR {
    /**
     * ✅ Key Insight
     * In a binary array:
     * 	•	OR of 1 with anything is 1
     * 	•	OR of all 0s is 0
     * So the only subarrays with OR = 0 are those that contain only 0s.
     * ✅ Total subarrays = N * (N + 1) / 2
     * ✅ Subarrays with OR = 1 = Total subarrays - Subarrays with all 0s
     * ✅ Algorithm Steps
     * 	1.	Count all subarrays of contiguous 0s.
     * 	2.	Subarrays with all 0s = for every block of k zeroes → k * (k + 1) / 2
     * 	3.	Return total subarrays - total 0-only subarrays
     * @param A
     * @return
     */

    public static long countSubarraysWithOR1(int[] A) {
        int n = A.length;
        long totalSubarrays = (long) n * (n + 1) / 2;

        long zeroBlock = 0;
        long zeroSubarrays = 0;

        for (int value : A) {
            if (value == 0) {
                zeroBlock++;
            } else {
                if (zeroBlock > 0) {
                    zeroSubarrays += zeroBlock * (zeroBlock + 1) / 2;
                    zeroBlock = 0;
                }
            }
        }

        // If array ends with 0s
        if (zeroBlock > 0) {
            zeroSubarrays += zeroBlock * (zeroBlock + 1) / 2;
        }

        return totalSubarrays - zeroSubarrays;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 1};
        System.out.println("Subarrays with OR = 1: " + countSubarraysWithOR1(A)); // Output: 5
    }
}
