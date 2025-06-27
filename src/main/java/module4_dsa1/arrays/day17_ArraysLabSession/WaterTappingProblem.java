package module4_dsa1.arrays.day17_ArraysLabSession;

public class WaterTappingProblem {
    /**
     * Given an array A[] of integers where each element represents the height of a bar,
     * compute how much water it can trap after raining.
     * @param heights
     * @return total water trapped
     */
    int trappedWaterApproach1(int[] heights) {
        int n = heights.length;
        int[] leftMaxArr = new int[n];
        leftMaxArr[0] = heights[0];
        int[] rightMaxArr = new int[n];
        rightMaxArr[n-1] = heights[n-1];

        int water = 0;
        for(int i=1;i<n;i++) {
            leftMaxArr[i] = Math.max(leftMaxArr[i-1],heights[i]);
        }
        for(int i=n-2;i>=0;i--) {
            rightMaxArr[i] = Math.max(rightMaxArr[i+1],heights[i]);
        }

        for(int i=0;i<n;i++) {
            water += Math.min(leftMaxArr[i],rightMaxArr[i]) - heights[i];
        }
        return water;
    }

    int trappedWaterApproach2(int[] A) {
        int leftMax = 0, rightMax=0;
        int left=0,right=A.length-1;
        int water = 0;

        while(left <= right) {
            if(A[left] <= A[right]) {
                if(A[left] >= leftMax) {
                    leftMax = A[left];
                } else {
                    water += leftMax - A[left];
                }
                left++;
            } else {
                if(A[right] >= rightMax) {
                    rightMax = A[right];
                } else {
                    water += rightMax - A[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        WaterTappingProblem wtp = new WaterTappingProblem();
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped Rain Water(approach 1): "+wtp.trappedWaterApproach1(A));
        System.out.println("Trapped Rain Water(approach 2): "+wtp.trappedWaterApproach2(A));
    }
}
