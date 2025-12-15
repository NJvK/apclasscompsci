public class PracticeQuiz {
    public void print(int [] arr){
        for (int num:arr){
            System.out.print(num + "");
        }
        System.out.println();
    }
    public boolean contains(int[]arr, int target){
        for (int num : arr){
            if (num == target){
                return true;
            }
        }
        return false;
    }
    public int getProduct(int[]arr){
        int product = 1;
        for (int num:arr){
            product *= num;
        }
        return product;
    }
    public int getLargest(int[]arr){
        int largest = arr[0];
        for (int num:arr){
            if (num>largest){
                largest = num;
            }
        }
        return largest;
    }
}
