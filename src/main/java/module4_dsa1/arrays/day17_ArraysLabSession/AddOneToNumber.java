package module4_dsa1.arrays.day17_ArraysLabSession;

import java.util.Arrays;
public class AddOneToNumber {
    /**
     * Problem Description
     * Given a non-negative number represented as an array of digits, add 1 to the number
     *  ( increment the number represented by the digits ).
     * The digits are stored such that the most significant digit is at the head of the list.
     * NOTE: Certain things are intentionally left unclear in this question which you should
     *  practice asking the interviewer. For example: for this problem, the following are some
     *      good questions to ask :
     * Q: Can the input have 0's before the most significant digit. Or, in other words, is
     *  0 1 2 3 a valid input?
     * A: For the purpose of this question, YES
     * Q: Can the output have 0's before the most significant digit? Or, in other words, is
     *  0 1 2 4 a valid output?
     * A: For the purpose of this question, NO. Even if the input has zeroes before the most
     *  significant digit.
     *
     *
     * Problem Constraints
     * 1 <= size of the array <= 1000000
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Step 1: Add 1 starting from the least significant digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return removeLeadingZeros(digits); // Step 2: Clean and return
            }
            digits[i] = 0;
        }

        // Step 3: If all were 9 (e.g., 999 -> 1000)
        int[] result = new int[n + 1];
        result[0] = 1;

        return result;
    }

    // Helper to remove leading zeros
    public static int[] removeLeadingZeros(int[] arr) {
        int i = 0;
        while (i < arr.length - 1 && arr[i] == 0) {
            i++;
        }
        return Arrays.copyOfRange(arr, i, arr.length);
    }

    public static void main(String[] args) {
        int[] input = {0, 0, 1, 2, 9}; // Expected output: [1, 3, 0]
        int[] result = plusOne(input);

        System.out.println("Result: " + Arrays.toString(result));
    }
}
