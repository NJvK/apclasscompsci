public class Test {
    public void print(int [] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void find(int [] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Found at index: " + i);
                return;
            } else {
                System.out.println("Not found");
            }
        }
    }
    public void getSummation(int [] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        System.out.println("Summation: " + sum);
    }
    public void getSmallest(int [] arr) {
        int smallest = arr[0];
        for (int num : arr) {
            if (num < smallest) {
                smallest = num;
            }
        }
        System.out.println("Smallest: " + smallest);
    }
}
