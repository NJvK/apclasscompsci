public class Runner {
    public static void main(String[] args) {

        StringReview review = new StringReview();

        char result1 = review.getChar("Hello World!", 2);
        System.out.println(result1);

        char result2 = review.getChar("Hello World!", 1);
        System.out.println(result2);

        int countO = review.countChar("Hello World!", 'o');
        System.out.println(countO);

        int countL = review.countChar("Hello World!", 'l');
        System.out.println(countL);
    }
}