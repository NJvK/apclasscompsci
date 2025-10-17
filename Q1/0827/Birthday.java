import java.util.Scanner;
public class Birthday {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double year, month, age_for_year, age_for_month, currentYear, currentMonth;

        System.out.println("Enter in the year you were born ");
        year = scan.nextDouble();

        System.out.println("Enter in the month you were born ");
        month = scan.nextDouble();

        currentYear = 2025;
        currentMonth = 9;

        age_for_year = (currentYear - year);
        age_for_month = (currentMonth - month);

        System.out.println("You are " + age_for_year + " years and " + age_for_month + " months old");
    }
}
