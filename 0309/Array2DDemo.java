import java.util.Scanner;

class Array2DDemo {
    private Scanner input = new Scanner(System.in);
    
    public void print2DInt(int[][] arr){
        for (int r =0; r < arr.length; r++){
            for (int c = 0; c < arr[r].length; c++){
                System.out.print(arr[r][c] + "\t");
            }
            System.out.println();
        }
    }   

    public int[][] test1(){
        int[][] set = new int[5][5];
        for (int r =0; r < set.length; r++){
            for (int c = 0; c < set[r].length; c++){
                set[r][c] = (int)(Math.random() * 10 + 1);
            }
        }
        return set;
    }

    public void test2(){
        int [][] arr = test1();
        print2DInt(arr);
        int largest = arr[0][0];
        for (int r =0; r < arr.length; r++){
            for (int c = 0; c < arr[r].length; c++){
                if (arr[r][c] > largest) {
                    largest = arr[r][c];
                }
            }
        }
        System.out.println(largest);
    }
    
    public void test3(){
        int[][] set = test1();
        print2DInt(set);
        System.out.println("Choose an int 1-10 to replace with 99");
        int num = input.nextInt();
        for (int r =0; r < set.length; r++){
            for (int c = 0; c < set[r].length; c++){
                if (set[r][c] == num) {
                    set[r][c] = 99;
                }
            }
        }
        print2DInt(set);
    }

    public void test4(){
        String [][] animals ={
            {"dog", "cat", "lion"},
            {"tiger", "bear", "wolf"},
            {"horse", "cow", "zebra"}
        };
        for (int r =0; r < animals.length; r++){
            for (int c = 0; c < animals[r].length; c++){
                System.out.print(animals[r][c] + "\t");
            }
            System.out.println();
        }
        input.nextLine();
        System.out.println("Choose an animal");
        String str = input.nextLine();
        int found = 0;
        for (int r =0; r < animals.length; r++){
            for (int c = 0; c < animals[r].length; c++){
                if (animals[r][c].equals(str)) {
                    found = 1;
                } 
            }
        }
        if (found == 1) System.out.println("Yes");
        else System.out.println("No");
    }
}