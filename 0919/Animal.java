public class Animal {
    private String animalType;
    private int age;
    public Animal() {
        this.animalType = "Blank";
        this.age = 0;
    }
    public Animal(String animalType, int age) {
        this.animalType = animalType;
        this.age = age;
    }
    public String getAnimalType() {
        return animalType;
    }
    public int getAge() {
        return age;
    }
    public void animalInfo() {
        System.out.println("Animal Type: " + animalType);
        System.out.println("Animal Age: " + age);
    }
}
