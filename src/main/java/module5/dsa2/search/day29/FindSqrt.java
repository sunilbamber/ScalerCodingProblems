package module5.dsa2.search.day29;

public class FindSqrt {
    public static void main(String[] args) {
        int num = 4;
        int result = findSqrt(num);
        System.out.println(String.format("Sqrt of %d is %d",num, result));
    }

    private static int findSqrt(int A) {
        if(A==1 || A==0)
            return A;
        long ans=-1;
        long low = 1,high=A;
        while(low<=high) {
            long mid = low + (high-low)/2;
            System.out.println(String.format("Ans: %d low: %d mid: %d high: %d",ans,low,mid,high));
            if(mid*mid == A)
                return (int) mid;
            else if(mid*mid < A) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return (int)ans;
    }
}
