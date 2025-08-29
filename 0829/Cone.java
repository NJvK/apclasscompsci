import java.lang.Math;
public class Cone {
     public static void main(String[] args) {
        double radius = 3;
        double height = 6;
        double volume = Math.PI * Math.pow(radius, 2) * height /3.0;
        System.out.println("volume: " + volume);
     }   
}
