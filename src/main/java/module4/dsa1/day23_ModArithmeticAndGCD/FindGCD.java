package module4.dsa1.day23_ModArithmeticAndGCD;

public class FindGCD {
    public static int findGCD(int A, int B) {
        if(A==0)
            return B;
        if(B==0)
            return A;
        return findGCD(B, A%B);
    }

    public static int findGCDOfArr(int[] A) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findGCD(10,4));
    }
}
