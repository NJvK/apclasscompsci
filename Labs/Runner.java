package Labs;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

public class Runner {
    public static void main (String []args){
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        // asking what catigory you want
        System.out.println("1. Math");
        System.out.println("2. Geography");
        // random numbers 1-100
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
        int randomIntBounded14 = random.nextInt(100);
        int randomIntBounded15 = random.nextInt(100);
        // answers for math
        double answer1,answer2 ,answer3, answer4, answer5, answer6, answer7, answer8, answer9;
        // answers for geography
        double GeographyAnswer1, GeographyAnswer2, GeographyAnswer3, GeographyAnswer4, GeographyAnswer5, GeographyAnswer6, GeographyAnswer7, GeographyAnswer8, GeographyAnswer9;
        int score = 0;
    
        // questions for math easy and hard
        double choice = scan.nextDouble();
        String qone = ("What is the area of a rectangle given the height " +randomIntBounded1 + " and with " + randomIntBounded2);
        String qtwo = ("What is the area of a square given the side " +randomIntBounded3);
        String qthree = ("What is the perimeter of a square given the side " +randomIntBounded4);
        String qfour = ("What is the perimeter of a rectangle given the height " +randomIntBounded5 + " and with " + randomIntBounded6);
        String qfive = ("What is the area of a circle given the radius " +randomIntBounded7);
        String qseven = ("What is the cercumfrance of a cercle given the radius " +randomIntBounded8);
        String qsix = ("What is the area of a triangle given the base " +randomIntBounded9 + " and height " + randomIntBounded10);
        String qnine = ("What is the area of a triangle given a " +randomIntBounded11 + " b " + randomIntBounded12 + " the angle of c " + randomIntBounded13);
        String qeight = ("Find the average between the two given numbers " + randomIntBounded14 + randomIntBounded15);
        
        // questions for math easy and hard
        String qOne = ("What is the Capital of France 1. paris 2. rome 3. venis");
        String qTwo = ("What is the worlds smallest country 1. andorra 2. vadican city 3. san morino");
        String qThree = ("What is the perimeter of a square given the side " +randomIntBounded4);
        String qFour = ("What is the perimeter of a rectangle given the height " +randomIntBounded5 + " and with " + randomIntBounded6);
        String qSix = ("What is the area of a circle given the radius " +randomIntBounded7);
        String qEight = ("What is the cercumfrance of a cercle given the radius " +randomIntBounded8);
        String qFive = ("What is the area of a triangle given the base " +randomIntBounded9 + " and height " + randomIntBounded10);
        String qSeven = ("What is the area of a triangle given a " +randomIntBounded11 + " b " + randomIntBounded12 + " the angle of c " + randomIntBounded13);
        String qNine = ("Find the average between the two given numbers " + randomIntBounded14 + randomIntBounded15);
                
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
                // question 6 hard area of a triangle given a b and angle c
                System.out.println(qnine);
                answer9 = scan.nextDouble();
                if (answer9 == Math.round(((0.5 * randomIntBounded11 * randomIntBounded12 * Math.sin(randomIntBounded13))* 100.0) / 100.0)){
                    System.out.println("Correct!");
                    score += 1;
                } else {
                    System.out.println("Incorrect the correct answer is " + Math.round(((0.5 * randomIntBounded11 * randomIntBounded12 * Math.sin(randomIntBounded13))* 100.0) / 100.0));
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
            // question 5 easy area of a triangle given base and hight
            System.out.println(qsix);
            answer6 = scan.nextDouble();
            if (answer6 == (randomIntBounded9 * randomIntBounded10 / 2.0)){
                System.out.println("Correct!");
                score += 1;
                System.out.println("Your score is " + score);
            } else {
                System.out.println("Incorrect the correct answer is " + (randomIntBounded9 * randomIntBounded10 / 2.0));
            }
            // question 6 easy find the averagle of the two given numbers
            System.out.println(qeight);
            answer8 = scan.nextDouble();
            if (answer8 == (randomIntBounded15 + randomIntBounded14 / 2.0)){
                System.out.println("Correct!");
                score += 1;
                System.out.println("Your score is " + score);
            } else {
                System.out.println("Incorrect the correct answer is " + (randomIntBounded15 + randomIntBounded14 / 2.0));
            }
            }
            if (score == 6){
                System.out.println("Your grade for this quiz is A");
            } else if (score == 5){
                System.out.println("Your grade for this quiz is B");
            } else if (score == 4){
                System.out.println("Your grade for this quiz is C");
            } else if (score == 3){
                System.out.println("Your grade for this quiz is D");
            } else {
                System.out.println("Your grade for this quiz is F");
            }
        } else if (choice == 2){
            // question one what is the capital of france
            System.out.println(qOne);
            GeographyAnswer1 = scan.nextInt();
            if (GeographyAnswer1 == 1){
                System.out.println("Correct");
                score += 1;
                System.out.println("Your current score is " + score);
            } else {
                System.out.println("Incorrect the correct answer is 1. paris");
                System.out.println("Your current score is " + score);
            }
            // question two what is the worlds smallest country
            System.out.println(qTwo);
            GeographyAnswer2 = scan.nextInt();
            if (GeographyAnswer2 == 2){
                System.out.println("Correct");
                score += 1;
                System.out.println("Your current score is " + score);
            } else {
                System.out.println("Incorrect the correct answer is 2. vadican city");
                System.out.println("Your current score is " + score);
            }
            // ---------------------------------------------
            // final grade
            if (score == 6){
                System.out.println("Your grade for this quiz is A");
            } else if (score == 5){
                System.out.println("Your grade for this quiz is B");
            } else if (score == 4){
                System.out.println("Your grade for this quiz is C");
            } else if (score == 3){
                System.out.println("Your grade for this quiz is D");
            } else {
                System.out.println("Your grade for this quiz is F");
            }
        } else {
            System.out.println("This isn't a possible answer rerun the code and try again");
        }
    }
}
