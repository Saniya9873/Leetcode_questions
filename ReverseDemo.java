// Code to reverse an array, string, and number in Java

import java.util.Arrays;

public class ReverseDemo {

    // Method to reverse an array
    public static void reverseArray(int[] array) {
        int start = 0, end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    // Method to reverse a string
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    // Method to reverse a number
    public static int reverseNumber(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }
    //for reversing a string:
    public static void reverseUsingStringBuilder(){
        StringBuilder sb=new StringBuilder("hello");
        for (int i = 0; i < sb.length()/2; i++) {
            int front=i;
            int back=sb.length()-1-i;
            char frontchar=sb.charAt(front);
            char backchar=sb.charAt(back);
            sb.setCharAt(front, backchar);
            sb.setCharAt(back, frontchar);
        }
        System.out.println(sb );
    }

    public static void main(String[] args) {
        // Reverse an array
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Original Array: " + Arrays.toString(array));
        reverseArray(array);
        System.out.println("Reversed Array: " + Arrays.toString(array));

        // Reverse a string
        String str = "Hello World";
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reverseString(str));

        // Reverse a number
        int num = 12345;
        System.out.println("Original Number: " + num);
        System.out.println("Reversed Number: " + reverseNumber(num));

        // using StringBuilder
        System.out.println("Reversed String :");
        reverseUsingStringBuilder();
        
    }
}

