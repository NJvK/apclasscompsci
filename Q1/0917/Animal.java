public class Animal {
    private String animalType;
    private int age;
    public void setVariables (String animalString, int ageInt) {
        animalType = animalString;
        age = ageInt;
    }

    public void info() {
        System.out.println("Animal: " + animalType + ", Age: " + age);
    }
}