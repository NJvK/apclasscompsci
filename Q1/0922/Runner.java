public class Runner {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.area();
        circle.cylinderVol(5);
        Circle circle1 = new Circle(10);
        circle1.area();
        circle1.cylinderVol(5);
    }
}
