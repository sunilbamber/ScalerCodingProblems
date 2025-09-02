package module5.dsa2.search.day31;

public class FindUniqueElement {

    static int findUnique(int arr[]) {
        int len = arr.length;

        if(len==1) return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[len-1] != arr[len-2]) return arr[len-1];
        int low = 0, high = len-1;

        while(low <= high) {

            int mid = low + (high-low)/2;
            System.out.println(String.format("low: %d mid: %d high: %d",low,mid,high));
            if(arr[mid] != arr[mid-1] && arr[mid]!=arr[mid+1])
                return arr[mid];

            if(arr[mid]==arr[mid-1]) // move to first occurrence
                mid = mid-1;

            if(mid%2==0) { // if first occurence is at even, move to left side
                low = mid+2;
            } else {    // else, right side
                high = mid-1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {3,3,5,5,7,7,1,1,2,2,5,5,8};
        int result = findUnique(arr);
        System.out.println(result);
    }
}
