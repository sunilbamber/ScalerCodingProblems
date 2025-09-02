package module4.dsa1.day23_ModArithmeticAndGCD;

public class TwoSumModProblem {
    /**
     * pair sum divisible by M
     */

    public static int pairSumDivisibleByM(int[] A, int M) {
        int count = 0;
        int freq[] = new int[M];

        for(int num : A) {
            if(num == 0) {
                freq[0]++;
            }
            int mod = num%M;
            freq[mod]++;
            count += freq[mod];
        }
        return count;
    }

    public static void main(String[] args) {
        int input[] = {1,2,4,3,3,0,1,2};
        int pairSumDivisibleByM = pairSumDivisibleByM(input, 5);
        System.out.println(pairSumDivisibleByM);
    }
}
