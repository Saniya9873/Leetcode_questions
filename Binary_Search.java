import java.util.*;

public class Binary_Search {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int target=4;
        int result=BinarySearch(arr, target);
        System.out.println(result);
    }
    static int BinarySearch(int[] arr, int target){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid] >target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
        

    }
}
