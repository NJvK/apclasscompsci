public class Test {
    public void randomCount() {
        int min = 10;
        int max = 20;
        int countLimit = (int)(Math.random() * (max - min + 1) + min); 
        
        System.out.println("Random count limit generated: " + countLimit);
        System.out.print("Counting from 1 to " + countLimit + ": ");
        
        for (int i = 1; i <= countLimit; i++) {
            System.out.print(i + (i < countLimit ? ", " : ""));
        }
        System.out.println();
    }
    public void randomSquare() {
        int min = 5;
        int max = 10;
        int side = (int)(Math.random() * (max - min + 1) + min); 

        System.out.println("\nRandom square side generated: " + side);
        System.out.println("Drawing a " + side + "x" + side + " square:");
        
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}