package module4_dsa1.arrays.day18_BitManipulation;

public class UnsetBit {
    public static int unsetBthBit(int A, int B) {
        /**
         * To unset the B-th bit:
         *  A = A & ~(1 << B);
         * 	•	1 << B → a number with only the B-th bit set
         * 	•	~(1 << B) → inverts it, making all bits 1 except B-th
         * 	•	A & ... → turns the B-th bit off, leaves all others unchanged
         */
        return A & ~(1 << B);
    }

    public static void main(String[] args) {
        int A = 29; // Binary: 11101
        int B = 3;  // Unset the 4th bit (counting from 0)

        int result = unsetBthBit(A, B);
        System.out.println("Updated A = " + result); // Output: 21 (10101)
    }
    /**
     * Problem Description
     * You are given two integers A and B.
     * If B-th bit in A is set, make it unset.
     * If B-th bit in A is unset, leave as it is.
     * Return the updated A value.
     *
     * Note:
     * The bit position is 0-indexed, which means that the least significant bit (LSB) has index 0.
     *
     *
     * Problem Constraints
     * 1 <= A <= 109
     * 0 <= B <= 30
     *
     */
}
