import java.util.Arrays;

class ArraysMethodExample{

public static void main(String[] args) {

        // Declare and initialize array
        int[] arr = {40, 10, 30, 20};

        // 1. Printing array (without loop)
        System.out.println("Original Array:");
       
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
        // Output: [40, 10, 30, 20]

        // 2. Sorting the array
        Arrays.sort(arr);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));
        // Output: [10, 20, 30, 40]

        // 3. Searching an element (binary search)
        int index = Arrays.binarySearch(arr, 30);

        System.out.println("Index of 30: " + index);
        // Output: Index of 30: 2

        // 4. Comparing two arrays
        int[] arr2 = {10, 20, 30, 40};

        boolean isEqual = Arrays.equals(arr, arr2);
        System.out.println("Both arrays are equal: " + isEqual);
        // Output: true

        // 5. Filling array with same value
        int[] arr3 = new int[5];  // size 5

        Arrays.fill(arr3, 7);
        System.out.println("Filled Array:");
        System.out.println(Arrays.toString(arr3));
        // Output: [7, 7, 7, 7, 7]
    }
}