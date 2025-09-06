package Labs;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

public class Runner {
    public static void main (String []args){
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println("1. Math");
        System.out.println("2. Geography");
        int randomIntBounded1 = random.nextInt(100);
        int randomIntBounded2 = random.nextInt(100);
        int randomIntBounded3 = random.nextInt(100);
        int randomIntBounded4 = random.nextInt(100);
        int randomIntBounded5 = random.nextInt(100);
        int randomIntBounded6 = random.nextInt(100);
        int randomIntBounded7 = random.nextInt(100);
        int randomIntBounded8 = random.nextInt(100);
        int randomIntBounded9 = random.nextInt(100);
        int randomIntBounded10 = random.nextInt(100);
        int randomIntBounded11 = random.nextInt(100);
        int randomIntBounded12 = random.nextInt(100);
        int randomIntBounded13 = random.nextInt(100);
        
        double answer1,answer2 ,answer3, answer4, answer5, answer6, answer7, answer8, answer9;
        int score = 0;
    
        int choice = scan.nextInt();
        String qone = ("What is the area of a rectangle given the height " +randomIntBounded1 + " and with " + randomIntBounded2);
        String qtwo = ("What is the area of a square given the side " +randomIntBounded3);
        String qthree = ("What is the perimeter of a square given the side " +randomIntBounded4);
        String qfour = ("What is the perimeter of a rectangle given the height " +randomIntBounded5 + " and with " + randomIntBounded6);
        String qfive = ("What is the area of a circle given the radius " +randomIntBounded7);
        String qseven = ("What is the cercumfrance of a cercle given the radius " +randomIntBounded8);
        String qsix = ("What is the area of a square given the base " +randomIntBounded9 + " and height " + randomIntBounded10);
        String qnine = ("What is the area of a triangle given a " +randomIntBounded11 + " b " + randomIntBounded12 + " the angle of c " + randomIntBounded13);
        // String qnine = ("What is the area of a square given the side " +randomIntBounded11);
    
                
        if (choice == 1){
            // question 1 area of a rectangle
            System.out.println(qone);
            answer1 = scan.nextDouble();
            if (answer1 == randomIntBounded1 * randomIntBounded2){
                System.out.println("Correct!");
                score += 1;
                System.out.println("Your score is " + score);
            } else {
                System.out.println("Incorrect the correct answer is " + (randomIntBounded1 * randomIntBounded2));
                System.out.println("Your score is " + score);
            }
            // question 2 area of a square
            System.out.println(qtwo);
            answer2 = scan.nextDouble();
            if (answer2 == Math.pow(randomIntBounded3, 2)){
                System.out.println("Correct!");
                score += 1;
                System.out.println("Your score is " + score);
            } else {
                System.out.println("Incorrect the correct answer is " + (Math.pow(randomIntBounded3, 2)));
                System.out.println("Your score is " + score);
            }
            // question 3 perimiter of a square
            System.out.println(qthree);
            answer3 = scan.nextDouble();
            if (answer3 == (randomIntBounded4 * 4)){
                System.out.println("Correct!");
                score += 1;
                System.out.println("Your score is " + score);
            } else {
                System.out.println("Incorrect the correct answer is " + (randomIntBounded4 * 4));
                System.out.println("Your score is " + score);
            }
            if (score == 3){
                // question 4 hard area of a circle
                System.out.println(qfive);
                answer5 = scan.nextDouble();
                if (answer5 == Math.round(((Math.PI * Math.pow(randomIntBounded7, 2))* 100.0) / 100.0)){
                    System.out.println("Correct!");
                    score += 1;
                } else {
                    System.out.println("Incorrect the correct answer is " + Math.round(((Math.PI * Math.pow(randomIntBounded7, 2))* 100.0) / 100.0));
                    System.out.println("Your score is " + score);
                }
                // question 5 hard cercumfrance of a circle
                System.out.println(qseven);
                answer7 = scan.nextDouble();
                if (answer7 == Math.round(((Math.PI * randomIntBounded8 * 2)* 100.0) / 100.0)){
                    System.out.println("Correct!");
                    score += 1;
                } else {
                    System.out.println("Incorrect the correct answer is " + Math.round(((Math.PI * randomIntBounded8 * 2)* 100.0) / 100.0));
                    System.out.println("Your score is " + score);
                }
            } else {
            // question 4 easy perimiter of a rectangle
            System.out.println(qfour);
            answer4 = scan.nextDouble();
            if (answer4 == (randomIntBounded5 * 2 + randomIntBounded6 * 2)){
                System.out.println("Correct!");
                score += 1;
                System.out.println("Your score is " + score);
            } else {
                System.out.println("Incorrect the correct answer is " + (randomIntBounded5 * 2 + randomIntBounded6 * 2));
            }
            // question 5 easy
            System.out.println(qsix);
            answer6 = scan.nextDouble();
            if (answer4 == (randomIntBounded5 * 2 + randomIntBounded6 * 2)){
                System.out.println("Correct!");
                score += 1;
                System.out.println("Your score is " + score);
            } else {
                System.out.println("Incorrect the correct answer is " + (randomIntBounded5 * 2 + randomIntBounded6 * 2));
            }
            }
        } else if (choice == 2){

        } else {
            System.out.println("This isn't a possible answer rerun the code and try again");
        }
    }
}
