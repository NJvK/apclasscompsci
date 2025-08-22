/*
 * 1. Area of a triangle
 * 2. Creat variables called base and height and area
 * 3. Print "Enter a base"
 * 4. Get a number from the user and set it to base
 * 5. Print "Enter a height"
 * 6. Get a number from the user and set it to height
 * 7. Calculate (base * height)/2 and set it to the area
 * 8. Print the "The area is: " + area
 */

import java.util.Scanner;
public class Triangles2{
    public static void main(String[] args) {
        System.out.println("Area of a Triangle");
        double base, height, area;

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter in a number: ");
		base = scan.nextDouble();


		System.out.println("Enter in another number: ");
		height = scan.nextDouble();

		System.out.println("You entered in " + base + " " + height);

        area = 0.5 * base* height;
        System.out.println("The area is " + area);
	}
}