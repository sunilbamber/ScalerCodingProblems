package module4.dsa1.bit_manipulation.day19_BitManipulationLabSession;

public class UniqueNumberFinder {

    /**
     * Problem Description
     * Given an array of integers, every element appears thrice except for one,
     *  which occurs once.
     * Find that element that does not appear thrice.
     * NOTE: Your algorithm should have a linear runtime complexity.
     * Could you implement it without using extra memory?
     *
     * Problem Constraints
     * 2 <= |A| <= 5*106
     * 0 <= A[i] <= INTMAX
     * @param nums
     * @return
     */

    public static int singleNumber(int[] nums) {
        /**
         * Intuition
         * 	•	For each bit position (0 to 31), count how many numbers have that bit set.
         * 	•	If a bit is set in the unique number, it will not be divisible by 3 in the total bit count.
         */
        int result = 0;

        // Go through each bit (assuming 32-bit integers)
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            int mask = (1 << i);

            for (int num : nums) {
                if ((num & mask) != 0) {
                    sum++;
                }
            }

            // If the sum is not divisible by 3, that bit belongs to the unique number
            if (sum % 3 != 0) {
                result |= mask;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println("Unique number is: " + singleNumber(nums)); // Output: 3
    }
}
