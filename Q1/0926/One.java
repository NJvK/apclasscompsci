public class One {
    private int length;
    private int width;
    public One() {
        this.length = 0;
        this.width = 0;
    }
    public One(int a, int b) {
        this.length = a;
        this.width = b;
    }
    public void area() {
        System.out.println("area: " + (this.length * this.width));
    }
    public void area(int a, int b) {
        System.out.println("area: " + (a * b));
    }
}
