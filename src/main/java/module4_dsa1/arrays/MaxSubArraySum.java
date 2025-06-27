package module4_dsa1.arrays;

public class MaxSubArraySum {

    /**
    https://www.geeksforgeeks.org/dsa/print-the-maximum-subarray-sum/
     */

    public static int findMaxSubArraySum(int[] arr) {

        int res = arr[0];
        int curr_sum = arr[0];
        int n = arr.length;

        for(int i=1; i<n; i++) {
            curr_sum = Math.max(curr_sum+arr[i], arr[i]);
            res = Math.max(res, curr_sum);
        }
        return res;
    }

    public static int[] printMaxSubArraySum(int[] arr) {

        // start and end of max sum subarray
        int resStart = 0, resEnd = 0;
        // start of current subarray
        int currStart = 0;

        int res = arr[0];
        int curr_sum = arr[0];
        int n = arr.length;

        for(int i=1; i<n; i++) {
            //curr_sum = Math.max(curr_sum+arr[i], arr[i]);
            if(curr_sum+arr[i] > arr[i]) {
                curr_sum = curr_sum+arr[i];
            } else {
                curr_sum = arr[i];
                currStart = i;
            }
            //res = Math.max(res, curr_sum);
            if(res < curr_sum) {
                resStart = currStart;
                resEnd = i;
                res = curr_sum;
            }
        }
        int[] resArr = new int[resEnd-resStart+1];
        for(int i=resStart,j=0;i<=resEnd;i++,j++) {
            resArr[j] = arr[i];
        }
        return resArr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        int res = findMaxSubArraySum(arr);
        System.out.println(res);

        int[] resArr = printMaxSubArraySum(arr);
        for(int num:resArr)
            System.out.print(num+ " ");
    }
}


/*
Dry run
arr[] = {2, 3, -8, 7, -1, 2, 3}
i=0
cur_sum = 2
max_sum = 2

i=1
cur_sum = max(2+3,3) = 5
max_sum = max(2,5) = 5

i=2
cur_sum = max(5-8,-8) = -3
max_sum = max(5,-3) = 5

i=3
cur_sum = max(-3+7,7) = 7
max_sum = max(5,7) = 7

i=4
cur_sum = max(7-1,-1) = 6
max_sum = max(7,6) = 7

i=5
cur_sum = max(6+2,6) = 8
max_sum = max(7,8) = 8

i=6
cur_sum = max(8+3,3) = 11
max_sum = max(8,11) = 11

result=11
 */
