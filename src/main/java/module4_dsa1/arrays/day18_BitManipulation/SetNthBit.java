package module4_dsa1.arrays.day18_BitManipulation;

public class SetNthBit {
    /**
     * Problem Description
     * You are given two integers A and B.
     * Set the A-th bit and B-th bit in 0, and return output in decimal Number System.
     *
     * Note:
     * The bit positions are 0-indexed, which means that the least significant bit (LSB) has index 0.
     */
    public static int solve(int A, int B) {

        return (1<<A) | (1<<B);
    }
    public static void main(String[] args) {
        int A = 3, B=5;

        System.out.println("Number formed: " + solve(A,B));
    }
}
