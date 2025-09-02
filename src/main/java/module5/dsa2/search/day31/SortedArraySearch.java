package module5.dsa2.search.day31;

import java.util.Arrays;

public class SortedArraySearch {
    public static void main(String[] args) {
        int[] arr = {1, 7, 67, 133, 178};//{12,23,34,54,1,2,3,4,6};
        System.out.println("Input: "+Arrays.toString(arr));
        int numToSearch = 1;//23;
        int result = sortedSearch2(arr, numToSearch);
        System.out.println(result);
    }

    private static int sortedSearch2(int[] A, int B) {
        int len = A.length;
        int low = 0, high = len-1;

        while(low<=high) {
            int mid = (low+high)/2;
            //System.out.println(String.format("low: %d mid: %d high: %d",low,mid,high));

            System.out.println(String.format("low: %d mid: %d high: %d",A[low],A[mid],A[high]));
            if(A[mid] == B) {
                return mid;
            } else if(A[low]<=A[mid]){

                if(A[low]<=B && B<A[mid])
                    high = mid-1;
                else {
                    low=mid+1;
                }
            } else if(A[mid]<=A[high]) {
                if(A[mid]<B && B<=A[high])
                    low=mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;

    }

    private static int sortedSearch(int[] arr, int numToSearch) {

        int len = arr.length;
        int low = 0, high = len-1;

        while(low <= high) {
            int mid = low + (high-low)/2;
            System.out.println(String.format("low: %d mid: %d high: %d",arr[low],arr[mid],arr[high]));
            //System.out.println(arr[low] +"<="+ arr[mid] +"&&"+ arr[low] +"<="+numToSearch +"&&"+ numToSearch+"<="+arr[mid]);
            if(arr[mid] == numToSearch)
                return mid;

            else if(arr[low]<=arr[mid]) {
                if (arr[low] <= numToSearch && numToSearch <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(arr[mid] <=numToSearch && numToSearch<=arr[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }

        return -1;
    }


}
