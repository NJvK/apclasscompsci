public class Runner {
    public static void main(String[] args) {
        Number num = new Number();
        boolean result = num.checkOddEven(5);
        double area = num.areaTriangle(4.5, 4.0);
        System.out.println("Is 5 odd? " + result);
        System.out.println("Area of triangle: " + area);
    }
    
}
