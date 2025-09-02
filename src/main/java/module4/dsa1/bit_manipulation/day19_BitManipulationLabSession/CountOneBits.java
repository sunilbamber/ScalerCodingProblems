package module4.dsa1.bit_manipulation.day19_BitManipulationLabSession;

/**
 * Write a function that takes an integer and returns the number of 1 bits
 * present in its binary representation.
 */
public class CountOneBits {
    public static int countOneBits(int n) {
        /**
         * Explanation
         * 	•	n & 1 checks the least significant bit (LSB)
         * 	•	n >>> 1 shifts right without preserving the sign bit (important for negative numbers)
         *
         * 	Or using Integer.bitCount(n) built-in method (Java)
         */
        int count = 0;
        while (n != 0) {
            count += (n & 1); // Add 1 if the last bit is set
            n = n >>> 1;      // Use unsigned right shift to handle negative numbers correctly
        }
        return count;
    }

    public static void main(String[] args) {
        int number = 29; // Binary: 11101
        System.out.println("Number of 1 bits: " + countOneBits(number)); // Output: 4
        System.out.println("Number of 1 bits using inbuilt function: "+Integer.bitCount(number));
    }
}
