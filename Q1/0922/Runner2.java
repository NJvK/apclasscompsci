public class Runner2 {
    public static void main(String[] args) {
        Circle2 circle2 = new Circle2();
        Circle2 circle21 = new Circle2(10.0);
        circle2.printArea1();
        circle21.printArea1();
        circle2.printArea2(5);
        circle21.printArea2(5);
        circle2.printVol1(7);
        circle2.printVol2(7, 10);
    }
}
