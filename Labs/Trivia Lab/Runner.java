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
        
        // questions for geography easy = even and hard = odd
        String qOne = ("What is the Capital of France? 1. paris 2. rome 3. venis");
        String qTwo = ("What is the worlds smallest country? 1. andorra 2. vadican city 3. san morino");
        String qThree = ("What country is famous for its pyramids and the Sphinx? 1. Brazil 2. Oman 3. Egypt");
        String qFour = ("What is the largest country in South America by area? 1. Brazil 2. Chile 3. Argentina");
        String qSix = ("What country is both a continent and a country? 1. Austrilia 2. Philipines 3. Soloman Islands");
        String qEight = ("In what country would you find the Eiffel Tower and the Louvre Museum? 1. Spain 2. France");
        String qFive = ("What is the only country in the world that lies on the equator and has no coastline? 1. Democratic Republic of the Congo 2. Brakina Faso 3. Uganda");
        String qSeven = ("Which two sovereign nations have coastlines on the Caspian Sea but do not share a land border? 1. Iran and Iraq 2. Iraq and Kazakhstan 3. Iran and Kazakhstan");
        String qNine = ("What country is the only one in the world that has a non-quadrilateral flag? 1. Moneco 2. Nepal 3. Quetar");
                
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
            // question three What country is famous for its pyramids and the Sphinx?
            System.out.println(qThree);
            GeographyAnswer3 = scan.nextInt();
            if (GeographyAnswer3 == 3){
                System.out.println("Correct");
                score += 1;
                System.out.println("Your current score is " + score);
            } else {
                System.out.println("Incorrect the correct answer is 3. Egypt");
                System.out.println("Your current score is " + score);
            }
            if (score == 3){
                // Hard questions
                // question 4 hard What is the only country in the world that lies on the equator and has no coastline?
                System.out.println(qFive);
            GeographyAnswer5 = scan.nextInt();
            if (GeographyAnswer5 == 3){
                System.out.println("Correct");
                score += 1;
                System.out.println("Your current score is " + score);
            } else {
                System.out.println("Incorrect the correct answer is 3. Uganda");
                System.out.println("Your current score is " + score);
            }
            // question 5 hard What is the only country in the world that lies on the equator and has no coastline?
            System.out.println(qSeven);
            GeographyAnswer7 = scan.nextInt();
            if (GeographyAnswer7 == 3){
                System.out.println("Correct");
                score += 1;
                System.out.println("Your current score is " + score);
            } else {
                System.out.println("Incorrect the correct answer is 3. Iran and Kazakhstan");
                System.out.println("Your current score is " + score);
            }
            // question 6 hard What is the only country in the world that lies on the equator and has no coastline?
            System.out.println(qNine);
            GeographyAnswer9 = scan.nextInt();
            if (GeographyAnswer9 == 2){
                System.out.println("Correct");
                score += 1;
                System.out.println("Your current score is " + score);
            } else {
                System.out.println("Incorrect the correct answer is 2. Nepal");
                System.out.println("Your current score is " + score);
            }
            } else {
                // Easy questions
                // question 4 easy What is the largest country in South America by area?
                System.out.println(qFour);
                GeographyAnswer4 = scan.nextInt();
                if (GeographyAnswer4 == 1){
                    System.out.println("Correct");
                    score += 1;
                    System.out.println("Your current score is " + score);
                } else {
                    System.out.println("Incorrect the correct answer is 1. Brazil");
                    System.out.println("Your current score is " + score);
                }
                // question 5 easy What country is both a continent and a country?
                System.out.println(qSix);
                GeographyAnswer6 = scan.nextInt();
                if (GeographyAnswer6 == 1){
                    System.out.println("Correct");
                    score += 1;
                    System.out.println("Your current score is " + score);
                } else {
                    System.out.println("Incorrect the correct answer is 1. Austilia");
                    System.out.println("Your current score is " + score);
                }
                // question 6 easy In what country would you find the Eiffel Tower and the Louvre Museum?
                System.out.println(qEight);
                GeographyAnswer8 = scan.nextInt();
                if (GeographyAnswer8 == 2){
                    System.out.println("Correct");
                    score += 1;
                    System.out.println("Your current score is " + score);
                } else {
                    System.out.println("Incorrect the correct answer is 2. France");
                    System.out.println("Your current score is " + score);
                }
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
