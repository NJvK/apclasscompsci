public class Runner {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        double volume = rectangle.volRect(5.0, 2.0, 10.0);
        System.out.println("Volume of the rectangle: " + volume);
    }
}
