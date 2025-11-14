public class ArrayTest2 {
    private int[] arr;

    // Constructor to initialize the array
    public ArrayTest2(int[] arr) {
        this.arr = arr;
    }

    /**
     * Void method to print all elements of the array.
     */
    public void printArray() {
        System.out.print("Array elements: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Boolean method: Searches for a number and returns true if found, false otherwise.
     * @param target The number to search for.
     * @return true if the target is in the array, false otherwise.
     */
    public boolean searchNumber1(int target) {
        for (int element : arr) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * Integer method: Searches for a number and returns its index if found, or -1 otherwise.
     * @param target The number to search for.
     * @return The index of the target number, or -1 if not found.
     */
    public int searchNumber2(int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index
            }
        }
        return -1; // Not found
    }

    /**
     * Returns the largest element in the array.
     * @return The largest element, or Integer.MIN_VALUE if the array is empty.
     */
    public int findLargest() {
        if (arr.length == 0) {
            return Integer.MIN_VALUE; // Sentinel value for an empty array
        }
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    /**
     * Returns the smallest element in the array.
     * @return The smallest element, or Integer.MAX_VALUE if the array is empty.
     */
    public int findSmallest() {
        if (arr.length == 0) {
            return Integer.MAX_VALUE; // Sentinel value for an empty array
        }
        int smallest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    /**
     * Returns the sum of all elements in the array.
     * @return The sum of all elements.
     */
    public long sum() {
        long total = 0; // Use long to prevent potential integer overflow
        for (int element : arr) {
            total += element;
        }
        return total;
    }

    /**
     * Returns the product of all elements in the array.
     * @return The product of all elements. Returns 1 for an empty array.
     */
    public long product() {
        if (arr.length == 0) {
            return 1; // Product of an empty set is 1
        }
        long result = 1; // Use long to prevent potential integer overflow
        for (int element : arr) {
            result *= element;
        }
        return result;
    }
}