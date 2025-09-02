package module4.dsa1.recursion.day20_Recursion;

public class SumOfDigits {
    static int sumOfDigits(int A) {
        /**
         123
         123/10 = fun(12) + 3 -> 12/10 (fun(1))+ 2 + 3 -> 1 + 2 + 3
         */

        /**
         * if(A==0)
         *  return 0;
         */

        if(A/10 == 0) {
            return A;
        } else {
            return sumOfDigits(A/10) + A%10;
        }
    }

    public static void main(String[] args) {
        int input = 123456;
        System.out.println("Sum of digits of " + input + " = " + sumOfDigits(input));
    }
}
