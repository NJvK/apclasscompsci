public class RadiusRunner {
    public static void main(String[] args) {
        Radius radius = new Radius();
        System.out.println("Radius Formulas");
        radius.setVariable();
        radius.printArea(10);
        radius.printCircumference(10);
        radius.printConeVolume(10, 5);
    }
}
