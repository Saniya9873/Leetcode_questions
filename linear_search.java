import java.util.Arrays;

public class linear_search {
    public static void main(String[] args) {
        //QUES-1: SEARCH IN STRING
        String name="Saniya";
        char target='i';
        System.out.println(search(name,target));

    }
    static boolean search(String str, char target){
        if (str.length() ==0){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (target==str.charAt(i)){
                return true;

            }
        }
        return false;
    

    //QUES-2: SEARCH IN RANGE
        int[] arr={18,12,-7,3,14,28};
        int target=3;
        System.out.println(linearSearch(arr, target, 1,4));
    }
    static int linearSearch(int[] arr,int target , int start,int end){
        if (arr.length==0){
            return -1;
        }
        for (int index= start; index<= end; index ++) {
            int element= arr[index];
            if(element==target){
                return index;
            }
        }
        return -1;
        

    // QUES-3: MINIMUM NUMBER
    int[] arr={18,12,-7,3,14,28};
    System.out.println(min(arr));
    }

    static int min(int[] arr){
        int ans=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<ans){
                ans=arr[i];
            }
        }
        return ans;
    

    //QUES-4: SEARCH IN 2D-ARRAYS
    int[][] arr={
        {1,2,3},
        {9,18,5},
        {6,7,14,16},
        {1,2}
    };
    int target=6;
    int[] ans=search(arr,target); 
    System.out.println(Arrays.toString(ans));

    }
    static int[]  search(int[][] arr,int target){
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(arr[row][col]== target){
                    return new int[] {row,col};

                }
            }
            
        }
        return new int[]{-1,-1};
    
    }
}
